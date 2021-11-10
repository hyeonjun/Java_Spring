package com.encore.rmgmt.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.rmgmt.Service.IntroduceService;
import com.encore.rmgmt.Service.IntroduceVO;

@Service("introduceService")
public class IntroduceServiceImpl implements IntroduceService {
	
	@Autowired	
	private IntroduceDAO introduceDAO;
	
	public IntroduceServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("===> IntroduceServiceImpl() °´Ã¼ »ý¼º");
	}

	/*@Override
	public void insertIntroduce(IntroduceVO vo) {
		// TODO Auto-generated method stub
		this.introduceDAO.insertIntroduce(vo);
	}*/

	/*@Override
	public void deleteIntroduce(IntroduceVO vo) {
		// TODO Auto-generated method stub
		this.introduceDAO.deleteIntroduce(vo);
	}*/

	@Override
	public void updateIntroduce(IntroduceVO vo) {
//		boolean result = false;
		System.out.println("===> in UpdateIntroduce : "+vo.toString());
		this.introduceDAO.updateIntroduce(vo);
//		return result;
	}

	@Override
	public IntroduceVO getIntroduce(IntroduceVO vo) {
		// TODO Auto-generated method stub
		return this.introduceDAO.getIntroduce(vo);
	}

	@Override
	public IntroduceVO getIntroduce(int seq) {
		// TODO Auto-generated method stub
		return this.introduceDAO.getIntroduce(seq);
	}

}
