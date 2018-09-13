package com.deepak.valueObject;

import java.util.ArrayList;
import java.util.List;

public class Logic {
	public static void main(String[] args) {
		//End dates have to be in ascending order
		List<FilterVO> lst1 = new ArrayList<FilterVO>();
		FilterVO filterVO2 = new FilterVO(); 
		filterVO2.setMIL_DEB("0");
		filterVO2.setMIL_FIN("1"); 
		lst1.add(filterVO2); 
		
		FilterVO filterVO3 = new FilterVO(); 
		filterVO3.setMIL_DEB("1");
		filterVO3.setMIL_FIN("2"); 
		lst1.add(filterVO3); 

		FilterVO filterVO4 = new FilterVO(); 
		filterVO4.setMIL_DEB("2"); 
		filterVO4.setMIL_FIN("3"); 
		lst1.add(filterVO4); 

		FilterVO filterVO10 = new FilterVO(); 
		filterVO10.setMIL_DEB("3"); 
		filterVO10.setMIL_FIN("4"); 
		lst1.add(filterVO10); 
		
		FilterVO filterVO5 = new FilterVO(); 
		filterVO5.setMIL_DEB("5"); 
		filterVO5.setMIL_FIN("6"); 
		lst1.add(filterVO5) ;

		FilterVO filterVO6 = new FilterVO(); 
		filterVO6.setMIL_DEB("6"); 
		filterVO6.setMIL_FIN("8"); 
		lst1.add(filterVO6); 

		FilterVO filterVO7 = new FilterVO(); 
		filterVO7.setMIL_DEB("20231"); 
		filterVO7.setMIL_FIN("20251"); 
		lst1.add(filterVO7); 
//
		FilterVO filterVO8 = new FilterVO(); 
		filterVO8.setMIL_DEB("20251"); 
		filterVO8.setMIL_FIN("20262"); 
		lst1.add(filterVO8); 
//
		FilterVO filterVO9 = new FilterVO(); 
		filterVO9.setMIL_DEB("20261"); 
		filterVO9.setMIL_FIN("20301"); 
		lst1.add(filterVO9); 

		System. out.println("lst1: \n"+lst1); 

		List<FilterVO> lst2 = new ArrayList<FilterVO>(); 
		lst2 = lst1; 

	//	System.out.println("lst2: \n"+lst2); 
		List<FilterVO> mtcSmplificationToBeRemovedLst = new ArrayList<FilterVO>(); 
		List<FilterVO> mtcSmplificationLst = new ArrayList<FilterVO>(); 
		List<FilterVO> normalSmplificationLst = new ArrayList<FilterVO>(); 
		normalSmplificationLst = lst1; 

		FilterVO tmpFilterVO = null;
		for (FilterVO lst1VO : lst1) { 
			for (FilterVO lst2VO : lst2) { 
				if(lst1VO.getMIL_FIN().equals(lst2VO.getMIL_DEB())){ // include MTC equal check here
					if(!mtcSmplificationLst.isEmpty() && mtcSmplificationLst.size()>0){
					tmpFilterVO = mtcSmplificationLst.get(mtcSmplificationLst.size()-1);
					}
					 if(null!=tmpFilterVO && Integer.parseInt(lst1VO.getMIL_DEB())>Integer.parseInt(tmpFilterVO.getMIL_DEB()) && Integer.parseInt(lst1VO.getMIL_DEB())<Integer.parseInt(tmpFilterVO.getMIL_FIN())){
						int i = mtcSmplificationLst.size()-1;
						int j = 0;
						for (FilterVO filterVO : mtcSmplificationLst) {
							if(j==i){
								filterVO.setMIL_FIN(lst2VO.getMIL_FIN());
							}
							j++;
						}
						tmpFilterVO=null;
						
						mtcSmplificationToBeRemovedLst.add(lst1VO); 
						mtcSmplificationToBeRemovedLst.add(lst2VO); 
					}else{

					FilterVO mtcSimplifiedVO = new FilterVO(); 
					mtcSimplifiedVO.setMIL_DEB(lst1VO.getMIL_DEB()); 
					mtcSimplifiedVO.setMIL_FIN(lst2VO.getMIL_FIN()); 
					mtcSmplificationLst.add(mtcSimplifiedVO); 

					mtcSmplificationToBeRemovedLst.add(lst1VO); 
					mtcSmplificationToBeRemovedLst.add(lst2VO); 
					
					}
				} 
			} 
		} 
		normalSmplificationLst.removeAll(mtcSmplificationToBeRemovedLst); 
		System. out.println("mtcSmplificationLst:\n"+mtcSmplificationLst); 
		System. out.println("normalSmplificationLst:\n"+normalSmplificationLst);;

	}
}
