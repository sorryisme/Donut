package com.donut.web.dao;

import java.util.List;

import com.donut.web.dto.CheerDTO;
import com.donut.web.dto.FavoriteDTO;
import com.donut.web.dto.GiveDTO;
import com.donut.web.dto.MemberDTO;
import com.donut.web.dto.ProjectDTO;
import com.donut.web.dto.QnADTO;

public interface MemberDAO {

	//ȸ������ - view �������� ��������
	public int memberInsert(MemberDTO memberDTO) throws Exception;

	//id �ߺ�üũ - �ߺ�üũ�� id
	public boolean memberDuplicatedById(String id) throws Exception;

	//id �α��� - id,���
	public MemberDTO memberSelectByIdPwd(String id, String pwd) throws Exception;

	//API�� �α���[����]
	public void loginAPI() throws Exception;

	//ȸ��Ż��
	public int memberDelete(MemberDTO memberDTO) throws Exception;

	//ȸ��Ż�� �� ���� �� ��й�ȣ Ȯ��
	public boolean memberDuplicatedByPwd(String id,String pwd) throws Exception;

	//����� ���������� - service���� ���� �����ֱ� 
	public MemberDTO memberSelectAll() throws Exception;

	//����� ���������� ������� - service���� ���� �����ֱ�
	public List<CheerDTO> memberSelectByCheer(String id) throws Exception;

	//����� ���������� QnA - service���� ���� �����ֱ�
	public List<QnADTO> memberSelectByQnA(String id) throws Exception;

	//ȸ������ ���� �� - service ���Ǻ����ֱ�
	public MemberDTO memberSelectById(String id) throws Exception;

	//����� ���������� ȸ������ �������� - view���� ���� ������������
	public int memberUpdate(MemberDTO memberDTO) throws Exception;

	//����� ���������� ���ã�� ����Ʈ - service ���Ǻ����ֱ�
	public List<FavoriteDTO> memberFavoriteList(String id) throws Exception;

	//����� ���������� ���ã�� ���� - favoriteNo �信�� �������� , service ���� ���̵� �����ֱ�
	public int memberFavoriteDelete(int favoriteNo,String id) throws Exception;

	//����� ���������� ������  ,service ���� ���̵� �����ֱ�
	public List<GiveDTO> memberReceiptList(String id) throws Exception;

	//����� ������Ʈ ��� ��Ȳ, service ���� ���̵� �����ֱ�
	public List<ProjectDTO> memberGiveList(String id) throws Exception;
}