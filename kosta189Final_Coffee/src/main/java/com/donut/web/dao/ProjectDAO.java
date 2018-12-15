package com.donut.web.dao;

import java.util.List;

import com.donut.web.dto.FavoriteDTO;
import com.donut.web.dto.ProjectDTO;

public interface ProjectDAO {

	//������Ʈ ��ü����
	public List<ProjectDTO> projectSelectAll() throws Exception;

	//������Ʈ �󼼺��� ,������Ʈ ���� ��������
	public ProjectDTO projectSelectByNo(int projectNo) throws Exception;

	//������Ʈ ī�װ����� ����
	public List<ProjectDTO> projectSelectByCategory1() throws Exception;

	//������Ʈ ī�װ���2�� ����
	public List<ProjectDTO> projectSelectByCategory2() throws Exception;

	//������Ʈ ī�װ���2�� ����
	public List<ProjectDTO> projectSelectByCategory3() throws Exception;

	//������Ʈ ���ã�� Ȯ�� - ���񽺿��� �����ֱ�
	public boolean projectFavoriteSelectByNo(FavoriteDTO favoriteDTO) throws Exception;

	//��ǰ ������Ʈ ���
	public int ItemInsert(ProjectDTO projectDTO) throws Exception;

	//���� ������Ʈ ���
	public int MoneyInsert(ProjectDTO projectDTO) throws Exception;

	//������Ʈ ����
	public int projectUpdate(ProjectDTO projectDTO) throws Exception;

	//���ã�� �߰�
	public int projectFavoriteInsert(FavoriteDTO favoriteDTO) throws Exception;

	//���ã�� ����
	public int projectFavoriteDelete(FavoriteDTO favoriteDTO) throws Exception;
	
	//������Ʈ ���� ���� �� �۾��� Ȯ��
	public boolean projectDuplicatedById(int ProjectNo) throws Exception;

}