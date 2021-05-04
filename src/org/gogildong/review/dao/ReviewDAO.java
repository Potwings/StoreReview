package org.gogildong.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.util.PageInfo;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;

public class ReviewDAO {

	private static final String NAMESPACE = "org.gogildong.review.dao.ReviewMapper";

	public List<Review> getReviewList(PageInfo pageInfo) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getList", pageInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void deleteReview(Long rno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.delete(NAMESPACE + ".delete", rno);

			session.commit();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Review getOneReview(Long rno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getOne", rno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertReview(Review review) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insert", review);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".updateLike", like);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".disLike", like);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Like selectLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".selectlike", like);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
			
			
			
//			int value;
//			
//			if(newlike == null) {
//				
//				return value = 0;
//				
//			}
//			
//			value = newlike.getValue();
//			
//			return value;
//			
			
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//
//	}

	public void insertLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insertLike", like);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getValue(Like like) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

//			return session.selectOne(NAMESPACE + ".getValue", like);

			Integer value = session.selectOne(NAMESPACE + ".getValue", like);
			
			if(value == null) {
				value = 0;
			}
			
			return value;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getTotal(Long sno) {
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+ ".getTotal",sno);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
