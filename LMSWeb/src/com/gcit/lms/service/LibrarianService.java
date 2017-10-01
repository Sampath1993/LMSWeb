package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.Library_BranchDAO;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.Library_Branch;

public class LibrarianService {
	
	public Utilities util = new Utilities();
	
	public List<Library_Branch> readBranch(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			Library_BranchDAO bdao = new Library_BranchDAO(conn);
			return bdao.readBranch(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public List<Book> readBooks(Library_Branch libraryBranch) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bdao = new BookDAO(conn);
			return bdao.readBooksByBranch(libraryBranch);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public void updateBranch(Library_Branch libraryBranch) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			Library_BranchDAO ldao = new Library_BranchDAO(conn);
			ldao.updateBranch(libraryBranch);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void updateNoOfCopies(BookCopies bookCopies) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookCopiesDAO bdao = new BookCopiesDAO(conn);
			bdao.updateBookCopies(bookCopies);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}

	public BookCopies showNoOfCopies(BookCopies bookCopies) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookCopiesDAO bdao = new BookCopiesDAO(conn);
			return bdao.showBookCopies(bookCopies);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
}
