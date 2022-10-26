import java.sql.*;
import java.util.ArrayList;

public class db {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/sakila?characterEncoding=UTF-8&severTimezone=UTC&useSSL=false";
		String id = "root";
		String password = "djaak10201028!";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loading success!");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("database connection success!");
		} catch (ClassNotFoundException e) {
			System.out.println("cannot find driver!");
		} catch (SQLException e) {
			System.out.println("connection failed!");
		}

		return con;
	}

	public static boolean isName(String name) {
		Connection con = makeConnection();
		PreparedStatement pstmt = null;
		String dbName = "";
		try {
			// select condition example
			String selectOneRow = "SELECT * FROM cus_info where name=? ";
			pstmt = con.prepareStatement(selectOneRow);
			pstmt.setString(1, name);

			ResultSet rsT = pstmt.executeQuery();
			while(rsT.next())
				dbName = rsT.getString(1);

		} catch (SQLException e) {
			System.out.println("connection failed! in main()");
		}

		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		;
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}
		;
		if (dbName.equals(name))
			return true;
		else
			return false;
	}

	public static int save_cus_info(cus_info cus) {
		Connection con = makeConnection();
		PreparedStatement pstmt = null;

		try {
			// insert example
			String insert = "INSERT INTO cus_info(name, seat_no, in_time)";
			insert += "VALUES ( ?, ?, ?)";

			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, cus.getName());
			pstmt.setInt(2, cus.getSeat_no());
			pstmt.setInt(3, cus.getIn_time());

			// insert, delete, update 구문 사용할 때, executeUpdate() return int
			int i = pstmt.executeUpdate();

			if (i != 1) {
				return -1;
			}
		} catch (SQLException e) {
			System.out.println("connection failed! in main()");
		}

		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		;
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}
		;
		return 1;
	}
	
	   public static void delete_cus(String name, int out_time) {
		      Connection con = makeConnection();
		      PreparedStatement pstmt = null;
		      cus_info cus = new cus_info();
		      int income = 0;
		      
		      try {
		         // select condition example
		         String selectOneRow = "SELECT * FROM cus_info where name=? ";
		         pstmt = con.prepareStatement(selectOneRow);
		         pstmt.setString(1, name);

		         ResultSet rsT = pstmt.executeQuery();
		         while(rsT.next()) {
		            cus.setName(rsT.getString(1));
		            cus.setSeat_no(rsT.getInt(2));
		            cus.setIn_time(rsT.getInt(3));
		            String insert = "INSERT INTO cus_history(name, seat_no, in_time, out_time, income)";
		            insert += "VALUES (?, ?, ?, ?, ?)";
		            income = 100 * (out_time - cus.getIn_time());
		            
		            pstmt = con.prepareStatement(insert);
		            pstmt.setString(1, cus.getName());
		            pstmt.setInt(2, cus.getSeat_no());
		            pstmt.setInt(3, cus.getIn_time());
		            pstmt.setInt(4, out_time);
		            pstmt.setInt(5, income);

		            // insert, delete, update ±¸¹® »ç¿ëÇÒ ¶§, executeUpdate() return int
		            pstmt.executeUpdate();
		            
		            String delete = "DELETE FROM cus_info WHERE name=?";
		            
		            pstmt = con.prepareStatement(delete);
		            pstmt.setString(1, cus.getName());
		            
		            pstmt.executeUpdate();
		         }

		      } catch (SQLException e) {
		         System.out.println("connection failed! in main()");
		      }

		      if (pstmt != null)
		         try {
		            pstmt.close();
		         } catch (SQLException e) {
		         }
		      ;
		      if (con != null)
		         try {
		            con.close();
		         } catch (SQLException e) {
		         }
		      ;
		   }
		//
		//   <관리자모드>
		//   -좌석상태
		   public static boolean state_seat(int seat_no) {
		      Connection con = makeConnection();
		      PreparedStatement pstmt = null;
		      
		      try {
		         // select condition example
		         String selectOneRow = "SELECT seat_no FROM cus_info";
		         pstmt = con.prepareStatement(selectOneRow);

		         ResultSet rsT = pstmt.executeQuery();
		         while(rsT.next())
		            if(seat_no == rsT.getInt(1))
		               return true;

		      } catch (SQLException e) {
		         System.out.println("connection failed! in main()");
		      }

		      if (pstmt != null)
		         try {
		            pstmt.close();
		         } catch (SQLException e) {
		         }
		      ;
		      if (con != null)
		         try {
		            con.close();
		         } catch (SQLException e) {
		         }
		      ;
		      return false;
		   }
		   
		//   -좌석상태 -> 리셋버튼누르면 리셋
		   public static void delete_cus_all() {
		      Connection con = makeConnection();
		      PreparedStatement pstmt = null;

		      try {
		         // insert example
		         String insert = "TRUNCATE cus_info";
		      

		         pstmt = con.prepareStatement(insert);

		         // insert, delete, update ±¸¹® »ç¿ëÇÒ ¶§, executeUpdate() return int
		         pstmt.executeUpdate();

		      } catch (SQLException e) {
		         System.out.println("connection failed! in main()");
		      }

		      if (pstmt != null)
		         try {
		            pstmt.close();
		         } catch (SQLException e) {
		         }
		      ;
		      if (con != null)
		         try {
		            con.close();
		         } catch (SQLException e) {
		         }
		      ;
		   }
		   //수입리셋
		   public static void delete_history() {
			      Connection con = makeConnection();
			      PreparedStatement pstmt = null;

			      try {
			         // insert example
			         String insert = "TRUNCATE cus_history";
			      

			         pstmt = con.prepareStatement(insert);

			         // insert, delete, update ±¸¹® »ç¿ëÇÒ ¶§, executeUpdate() return int
			         pstmt.executeUpdate();

			      } catch (SQLException e) {
			         System.out.println("connection failed! in main()");
			      }

			      if (pstmt != null)
			         try {
			            pstmt.close();
			         } catch (SQLException e) {
			         }
			      ;
			      if (con != null)
			         try {
			            con.close();
			         } catch (SQLException e) {
			         }
			      ;
			   }

		//   -손님현황 -> 있는 사람들 보여줘
		   public static ArrayList<cus_info> exist_cus_info() {
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ArrayList<cus_info> list = new ArrayList<cus_info>();
		      ResultSet rs = null;

		      try {
		         conn = makeConnection();
		         String sql = "SELECT * FROM cus_info";
		         pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();

		         while (rs.next()) {
		            cus_info info = new cus_info();

		            info.setName(rs.getString("name"));
		            info.setSeat_no(rs.getInt("seat_no"));
		            info.setIn_time(rs.getInt("in_time"));

		            list.add(info);
		         }
		      } catch (Exception e) {
		         // TODO: handle exception
		         e.printStackTrace();
		      }finally { // 오픈한 역순으로 닫기작업 실행

		         // resultset= > statement=> connection

		         try {
		            if (rs != null) {
		               rs.close();
		            }

		         } catch (Exception e2) {
		            e2.printStackTrace();
		         }

		         try {
		            if (pstmt != null) {
		               pstmt.close();
		            }

		         } catch (Exception e2) {
		            e2.printStackTrace();
		         }

		         try {
		            if (conn != null) {
		               conn.close();
		            }

		         } catch (Exception e2) {
		            e2.printStackTrace();
		         }

		      }   
		      return list;
		   }

		//   -수입-> 총수입
		   public static int total_income() {
		      Connection con = makeConnection();
		      PreparedStatement pstmt = null;
		      int result = 0;
		      
		      try {
		         // select condition example
		         String selectOneRow = "SELECT SUM(income) FROM cus_history";
		         pstmt = con.prepareStatement(selectOneRow);

		         ResultSet rsT = pstmt.executeQuery();
		         while(rsT.next())
		            result = rsT.getInt(1);

		      } catch (SQLException e) {
		         System.out.println("connection failed! in main()");
		      }

		      if (pstmt != null)
		         try {
		            pstmt.close();
		         } catch (SQLException e) {
		         }
		      ;
		      if (con != null)
		         try {
		            con.close();
		         } catch (SQLException e) {
		         }
		      ;
		      return result;
		      
		   }
		   
		   public static cus_info ret_cus_info(String name) {
			      Connection con = makeConnection();
			      PreparedStatement pstmt = null;
			      cus_info cus = new cus_info();
			  			      
			      try {
			         // select condition example
			         String selectOneRow = "SELECT * FROM cus_info where name=? ";
			         pstmt = con.prepareStatement(selectOneRow);
			         pstmt.setString(1, name);

			         ResultSet rsT = pstmt.executeQuery();
			         while(rsT.next()) {
			            cus.setName(rsT.getString(1));
			            cus.setSeat_no(rsT.getInt(2));
			            cus.setIn_time(rsT.getInt(3));
			         }

			      } catch (SQLException e) {
			         System.out.println("connection failed! in main()");
			      }

			      if (pstmt != null)
			         try {
			            pstmt.close();
			         } catch (SQLException e) {
			         }
			      ;
			      if (con != null)
			         try {
			            con.close();
			         } catch (SQLException e) {
			         }
			      ;
			      return cus;
			   }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Connection con = makeConnection();
//		PreparedStatement pstmt = null;
//
//		try {
//			// Statement stmt=con.createStatement();
//
//			// insert example
//			Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//
//			String insert = "INSERT INTO city(city_id,city,country_id, last_update)";
//			insert += "VALUES ( '601', 'Seoul', '82', ?)";
//
//			pstmt = con.prepareStatement(insert);
//			pstmt.setTimestamp(1, timestamp);
//
//			// insert, delete, update 구문 사용할 때, executeUpdate() return int
//			int i = pstmt.executeUpdate();
//
//			if (i == 1) {
//				System.out.println("record add success!!");
//			} else {
//				System.out.println("record add failed!!");
//			}
//
//			// select condition example
//			String selectOneRow = "SELECT * FROM city where city=?";
//			pstmt = con.prepareStatement(selectOneRow);
//			pstmt.setString(1, "Seoul");
//
//			ResultSet rsT = pstmt.executeQuery();
//			while (rsT.next()) {
//				int num = rsT.getInt(1);
//				String cityName = rsT.getString(2);
//				Timestamp ts = rsT.getTimestamp(4);
//				System.out.println(num + "\t" + cityName + "\t" + ts);
//			}
//
//			// delete example
//			String delete = "DELETE FROM city WHERE city_id=?";
//
//			pstmt = con.prepareStatement(delete);
//			pstmt.setInt(1, 601);
//
//			int j = pstmt.executeUpdate();
//
//			if (j == 1) {
//				System.out.println("record delete success!!");
//			} else {
//				System.out.println("recoed delete failed!!");
//			}
//
//			// update example
//			String update = "UPDATE city SET city=? WHERE city_id=?";
//			pstmt = con.prepareStatement(update);
//			pstmt.setString(1, "Busan");
//			pstmt.setInt(2, 1);
//
//			int t = pstmt.executeUpdate();
//
//			if (t == 1) {
//				System.out.println("record update success!!");
//			} else {
//				System.out.println("record update failed!!");
//			}
//
//			// select example
//			String select = "SELECT * FROM city";
//			pstmt = con.prepareStatement(select);
//
//			// select 구문을 사용할 때, executeQuery() return ResultSet
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String city_name = rs.getString(2);
//				System.out.println(city_name);
//			}
//			if (rs != null)
//				try {
//					rs.close();
//				} catch (SQLException e) {
//				}
//			;
//			if (rsT != null)
//				try {
//					rsT.close();
//				} catch (SQLException e) {
//				}
//			;
//		} catch (SQLException e) {
//			System.out.println("connection failed! in main()");
//		}
//
//		if (pstmt != null)
//			try {
//				pstmt.close();
//			} catch (SQLException e) {
//			}
//		;
//		if (con != null)
//			try {
//				con.close();
//			} catch (SQLException e) {
//			}
//		;
//	}
}
