package com.example.midivideomapper.db;

import java.sql.*;

public class DatabaseUtil {

	private static final String DB_URL = "jdbc:sqlite:midi_video_mapper.db"; // Path to your SQLite database

	public static Connection connect() {
		Connection conn = null;
		try {
			// Create a connection to the database
			conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void initializeDatabase() {
		// SQL statement for creating a new table
		String sql = """
			 CREATE TABLE IF NOT EXISTS videos (
			 	id integer PRIMARY KEY AUTOINCREMENT,
				title text NOT NULL,
				description text,
				duration real,
				url text NOT NULL
			);
			""";

		try (Connection conn = connect();
				 Statement stmt = conn.createStatement()) {
			// Create a new table
			stmt.execute(sql);
			System.out.println("Table 'videos' has been created.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertVideo(String title, String description, double duration) {
		String sql = "INSERT INTO videos(title, description, duration) VALUES(?,?,?)";

		try (Connection conn = connect();
				 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setDouble(3, duration);
			pstmt.executeUpdate();
			System.out.println("A new video has been inserted.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
