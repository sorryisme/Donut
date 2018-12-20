package com.donut.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.donut.web.dto.CheerDTO;
import com.donut.web.service.CheerService;



@Controller
@RequestMapping("/cheer")
public class CheerController {

	//幻鉦 板据聖 廃 紫寓戚檎 奇越聖 含 呪 赤惟 繕闇 陥澗 依
	//い ~拭辞 走榎 室芝焼戚巨櫛 搾嘘背辞 糎仙馬檎? 奇越 公 含惟. 益艦猿 糎仙馬澗 蕉亜 duplicate姥蟹 焼馬
	//廃 腰 奇越聖 舘 奄採切人 奄採舘端澗 希 戚雌 越聖 承 呪 蒸惟
	//室芝 焼戚巨 端滴馬澗 暗

	CheerDTO result;
	int parentNo;
	

	@Autowired
	private CheerService cheerService;
	
	// 室芝 焼戚巨 閤焼神澗暗 背醤背~~~~~~~~~~~~~~~~~~~~~~~~~~!!!!!!!!
		// 奇越 去系
		@RequestMapping("cheerInsert")
		public String cheerInsert(CheerDTO cheerDTO) {
			//System.out.println(cheerDTO.getCheerContent()+"/"+cheerDTO.getId()+"/"+cheerDTO.getProjectNo());
			try {
				if(cheerService.cheerInsert(cheerDTO)==1) {

					return "redirect:/project/projectRead?projectNo="+cheerDTO.getProjectNo()+"#cheer";
				}
			} catch (Exception e) {

				e.printStackTrace();
			}

			return "cheer/cheerInsertForm"; 
		}


	 //企奇越 廿句趨層陥.+誓据奇越 腰硲 達焼層陥.(刊牽檎 textarea蟹神澗 採歳精 焼送 姥薄 照 敗)
/*		@RequestMapping("/cheerReplyForm")
		@ResponseBody
		public CheerDTO cheerReplyForm(@RequestParam("cheerParentNo") int cheerParentNo) {
			System.out.println(cheerParentNo);
			parentNo = cheerParentNo;
			try {
				replyresult = cheerService.cheerSelectByNo(cheerParentNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return replyresult;
		}	
*/
		// 企奇越 DB拭 去系
		@RequestMapping("cheerReplyInsert")
		public String cheerReplyInsert(CheerDTO cheerDTO) {
			//parentNo = cheerParentNo;
			cheerDTO.setCheerParentNo(cheerDTO.getCheerNo());
			
			System.out.println("sss??? : " +cheerDTO.getProjectNo());
			System.out.println("sss??? : " +cheerDTO.getCheerContent());
			System.out.println("sss??? : " +cheerDTO.getCheerNo());
			System.out.println("sss??? : " +cheerDTO.getCheerParentNo());
			try {
				if(cheerService.cheerReplyInsert(cheerDTO)==1)
					
					return "redirect:/project/projectRead?projectNo="+cheerDTO.getProjectNo()+"#cheer";
			
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "cheer/cheerInsertForm"; 
		}	

		// 奇越 呪舛馬奄 是背 腰硲 達焼身
		@RequestMapping("/cheerUpdateForm")	
		@ResponseBody
		public CheerDTO cheerUpdateForm(@RequestParam("cheerNo") int cheerNo) {
			
			System.out.println(cheerNo);
			
			try {
				result = cheerService.cheerSelectByNo(cheerNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		// 奇越 呪舛
		@RequestMapping("cheerUpdate")
		@ResponseBody
		public Object cheerUpdate(@RequestParam("cheerContent") String cheerContent, CheerDTO cheerDTO) {

			cheerDTO = result;
			System.out.println(cheerDTO.getCheerNo() + " / " +cheerDTO.getCheerParentNo() + " / " + cheerDTO.getCheerNotify());
			
			System.out.println(cheerContent);
			cheerDTO.setCheerContent(cheerContent);
			
			if(cheerDTO.getCheerParentNo()==0) {
				System.out.println("剰澗 採乞越戚陥.");
			}else {
				System.out.println("剰澗 切縦越戚陥.");
			}
			
			
			try {
				cheerService.cheerUpdate(cheerDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("呪舛 板");
			System.out.println(cheerDTO.getCheerNo());
			System.out.println(cheerDTO.getId());
			System.out.println(cheerDTO.getCheerContent());

			//return "redirect:/project/projectRead?projectNo="+cheerDTO.getProjectNo()+"#cheer";
			Map<String,Object> updateResult = new HashMap<>();
			updateResult.put("message", "呪舛鞠醸柔艦陥.");
			return updateResult;//訊照掬だだだだだだだだだだだだだだだだだだだだだだだだだだだだ
		}

		// 奇越肢薦
		@RequestMapping("cheerDelete")
		@ResponseBody
		public Object cheerDelete(String id, @RequestParam("cheerNo") int cheerNo,  @RequestParam("cheerParentNo") int cheerParentNo,@RequestParam("projectNo") int projectNo) {
			Map <String, Object> deleteResult = new HashMap<>();
			id="test2"; // 戚暗 蟹掻拭 session 焼戚巨 葵 閤焼神室推. 
			System.out.println(cheerNo);
			int delete_success=0;
			try {
				delete_success = cheerService.cheerDelete(id, cheerNo, cheerParentNo);
				
				System.out.println(delete_success);
				if(delete_success != 0) {
					deleteResult.put("message", "肢薦鞠醸柔艦陥.");
				} else {
					deleteResult.put("message", "沙昔 奇越幻 肢薦拝 呪 赤柔艦陥.");
				}
				
				} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(deleteResult);
			return deleteResult; 
					
					//"redirect:/project/projectRead?projectNo="+projectNo+"#cheer";
	}


		// 戚耕 奇越拭 背雁 焼戚巨亜 糎仙馬澗走 溌昔
		public int cheerDuplicatedById(String id, int projectNo) { // id拭 session 焼戚巨 隔生檎 吉陥.(敗呪 採研 凶)

			boolean duplicatedResult;
			try {
				duplicatedResult = cheerService.cheerDuplicatedById(id, projectNo);

				if(duplicatedResult==false) System.out.println("戚 覗稽詮闘拭 去系吉 奇越戚 蒸柔艦陥.");
				else System.out.println("戚 覗稽詮闘拭 戚耕 去系廃 奇越戚 赤柔艦陥.");

			} catch (Exception e) {
				e.printStackTrace();
			}
			// else税 井酔拭 奇越 厳澗 依 竺舛
			// 戚 敗呪 insert拝 凶 潤醤敗~

			return 0;
		}	
}
