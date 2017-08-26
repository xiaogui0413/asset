package com.xipunet.servlet;


import com.xipunet.commons.PageBean;
import com.xipunet.entity.Assets;
import com.xipunet.entity.Log;
import com.xipunet.service.AssetsService;
import com.xipunet.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 资产web层
 * @author hgq
 *
 */
public class AssetsServlet extends HttpServlet {

	private static final long serialVersionUID = 1550037156891814407L;
	Assets assets = new Assets();
	AssetsService assetsService = new AssetsService();
	String uri = "";
	LogService logService = new LogService();

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//设置编码统一
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取操作类型
		String method = request.getParameter("method");
		//判断，根据不同的操作类型，来选择不通的处理方法
		if("list".equals(method)){
			list(request,response);
			
		}
		else if("saveAssetsWH".equals(method)){
			saveAssetsWH(request,response);

		}
		else if("update".equals(method)){
			update(request, response);
			
		}
		else if("delete".equals(method)){
			delete(request, response);	
		}
		else if("sumByType".equals(method)){
			sumByType(request, response);	
		}
		else if("sumByCompany".equals(method)){
			sumByCompany(request, response);	
		}
		else if("viewUpdate".equals(method)){
			viewUpdate(request, response);
		}
		else if("search2".equals(method)){
			search2(request, response);
		}
		else if("findByPage".equals(method)){
			findByPage(request, response);
		}
		else if("findByPage2".equals(method)){
			findByPage2(request, response);
		}
		else if("HSSF1".equals(method)){
			HSSF1(request, response);
		}

	}
	
	//资产列表
	public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Assets> list = assetsService.findAll();
		request.setAttribute("listAssets", list);
		uri = "/detail/wuhan_pc.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
		//uri= "/sys/detail/cuisineList.jsp";
		//request.getRequestDispatcher(uri).forward(request, response);
		
	}
	
	//保存资产--武汉
	public void saveAssetsWH(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//获取参数
		String users = request.getParameter("users");
		String p_type = request.getParameter("p_type");
		String amount = request.getParameter("amount");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		String configration = request.getParameter("configration");
		String serial_number = request.getParameter("serial_number");
		String buy_time = request.getParameter("buy_time");
		String receive_time = request.getParameter("receive_time");
		String p_status = request.getParameter("p_status");
		String number = request.getParameter("number");
		String remark = request.getParameter("remark");
		String type_id = request.getParameter("type_id");
		String company_id = request.getParameter("company_id");
		System.out.println(remark.length());

		//将获取的数据进行封装
		Assets assets = new Assets();
		assets.setUsers(users);
		assets.setP_type(p_type);
		assets.setAmount(amount);
		assets.setModel(model);
		assets.setPrice(price);
		assets.setConfigration(configration);
		assets.setSerial_number(serial_number);
		assets.setBuy_time(buy_time);
		assets.setReceive_time(receive_time);
		assets.setP_status(p_status);
		assets.setNumber(number);
		assets.setRemark(remark);
		assets.setType_id(Integer.parseInt(type_id));
		assets.setCompany_id(Integer.parseInt(company_id));
		
		//调用保存方法，对数据进行添加操作
		assetsService.save(assets);
		
		//记录日志
		Log log = new Log();
		log.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.setOperator(request.getSession().getAttribute("sessionUser").toString());
		log.setContent("增加资产");
		//todo 下面的参数为字符串如：s="id：1，所有者：admin，……，备注：无"
		log.setRemark("id：1，所有者：admin，……，备注：无");
		logService.add(log);
		
		findByPage(request,response);
	}

	//删除操作
	public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id = request.getParameter("id");
		assetsService.delete(Integer.parseInt(id));

		// 记录日志
		Log log = new Log();
		log.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()));
		log.setOperator(request.getSession().getAttribute("sessionUser")
				.toString());
		log.setContent("删除资产");
		log.setRemark("id："+id);
		logService.add(log);

		findByPage(request, response);
}
	//更新操作
	public void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//获取参数
		        int id = Integer.parseInt(request.getParameter("id"));
				String users = request.getParameter("users");
				String p_type = request.getParameter("p_type");
				String amount = request.getParameter("amount");
				String model = request.getParameter("model");
				String price = request.getParameter("price");
				String configration = request.getParameter("configration");
				String serial_number = request.getParameter("serial_number");
				String buy_time = request.getParameter("buy_time");
				String receive_time = request.getParameter("receive_time");
				String p_status = request.getParameter("p_status");
				String number = request.getParameter("number");
				String remark = request.getParameter("remark");

				//将获取的数据进行封装
				Assets assets = new Assets();
				assets.setId(id);
				assets.setUsers(users);
				assets.setP_type(p_type);
				assets.setAmount(amount);
				assets.setModel(model);
				assets.setPrice(price);
				assets.setConfigration(configration);
				assets.setSerial_number(serial_number);
				assets.setBuy_time(buy_time);
				assets.setReceive_time(receive_time);
				assets.setP_status(p_status);
				assets.setNumber(number);
				assets.setRemark(remark);
				assetsService.update(assets);
				
				//记录日志
				Log log = new Log();
				log.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				log.setOperator(request.getSession().getAttribute("sessionUser").toString());
				log.setContent("修改资产");
				//todo 下面的参数为字符串如：s="所有者：admin 改为 user1，……，备注：无 改为 固定资产"
				log.setRemark("所有者：admin 改为: "+users+"，……，备注改为 :"+remark);
//				log.setRemark("使用者："+users+"类别改为："+p_type+"数量改为："+amount+"型号改为："+model+"价值改为："+price
//						+"配置改为："+configration+"序列号改为："+serial_number+"购买时间改为："+buy_time+"领取时间改为："+
//						receive_time+"使用状态改为："+p_status+"编号改为"+number+"备注改为："+remark
//						);
			if(log.getRemark().length()>20){
				
			}
				logService.add(log);
				
				findByPage(request, response);
}
	//更新预览方法
	public void viewUpdate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id = request.getParameter("id");
		String id1 = request.getParameter("type_id");
		String id2 = request.getParameter("company_id");
		request.setAttribute("type_ids", id1);
		request.setAttribute("company_ids", id2);
		Assets as = assetsService.findById(Integer.parseInt(id));
		request.setAttribute("Assets", as);
		uri = "/detail/updateAssets.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
		
}
	//通过使用者查找
	public void search(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String users = request.getParameter("keyword");
		List<Assets> list = assetsService.findByName(users);
		request.setAttribute("listAssets", list);
		uri = "/detail/wuhan_pc.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
	
}
	//按照使用者模糊查询
	public void search2(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String users = request.getParameter("keyword");
		List<Assets> list = assetsService.findByName2(users);
		request.setAttribute("listAssets", list);
		uri = "/detail/wuhan_pc.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
	}
	//分页查询
	public void findByPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		try {
			
			String currPage = request.getParameter("currentPage");
			String type_id = request.getParameter("type_id");
			String company_id = request.getParameter("company_id");
			int type_ids = Integer.parseInt(type_id);
			int company_ids = Integer.parseInt(company_id);
			
			assets.setType_id(type_ids);
			assets.setCompany_id(company_ids);
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	
			}
		
			int currentPage = Integer.parseInt(currPage);

			PageBean<Assets> pageBean = new PageBean<Assets>();
			pageBean.setCurrentPage(currentPage);
			assetsService.getAll(pageBean,type_ids,company_ids);  
		List<Assets> list = assetsService.findNamesByIds(company_ids, type_ids);
		for(Assets a : list){
			System.out.println(a.getRemark());
			
		}


			request.setAttribute("pageBean", pageBean);
			request.setAttribute("type_ids", type_ids);
			request.setAttribute("company_ids", company_ids);
			uri = "/detail/wuhan_pc.jsp";
		} catch (Exception e) {
			e.printStackTrace(); 
			
			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}
	//按照用户名全局搜索
	public void findByPage2(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		try {
			
			String currPage = request.getParameter("currentPage");
			String users = request.getParameter("keyword");
			
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	
			}
		
			int currentPage = Integer.parseInt(currPage);

			PageBean<Assets> pageBean = new PageBean<Assets>();
			pageBean.setCurrentPage(currentPage); 
			assetsService.getAll(pageBean,users); 
			request.setAttribute("pageBean", pageBean);
			uri = "/detail/search.jsp";
		} catch (Exception e) {
			e.printStackTrace(); 
			
			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	
	}

	
	//按照公司汇总
	public void sumByCompany(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
	}
	
	//按照类型汇总
	public void sumByType(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Assets> list = assetsService.sumByType();
		request.setAttribute("listAssets", list);

		uri = "/chart.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void HSSF1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
        //第一步:创建一个工作簿excel文件  
        Workbook workbook=new HSSFWorkbook();//HSSF操作Excel2003以下版本 
         
        //第二步:创建一个工作表sheet  
        Sheet sheet=workbook.createSheet("Assets"); 
        //设置标题样式
        HSSFCellStyle headerStyle = (HSSFCellStyle) workbook .createCellStyle();// 创建标题样式  
        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);    //设置垂直居中  
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //设置水平居中  
        HSSFFont headerFont = (HSSFFont) workbook.createFont(); //创建字体样式  
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
        headerFont.setFontName("Times New Roman");  //设置字体类型  
        headerFont.setFontHeightInPoints((short) 18);    //设置字体大小  
        headerStyle.setFont(headerFont);    //为标题样式设置字体样式  
        
        sheet.setDefaultColumnWidth((short) 15);

        //第三步:创建一个行对象(我们放在第4行)  
        Row nRow=sheet.createRow(1);//从0开始  
          
        //第四步:创建一个单元格对象，指定列  
        //createCell参数有两个，一个是第几列一个是参数类型，  
        //这里我们使用默认参数类型  
        //第五步:给单元格设置内容  
        nRow.createCell(0).setCellValue("使用者");  
        nRow.createCell(1).setCellValue("类别"); 
        nRow.createCell(2).setCellValue("数量");  
        nRow.createCell(3).setCellValue("型号"); 
        nRow.createCell(4).setCellValue("价值");  
        nRow.createCell(5).setCellValue("配置"); 
        nRow.createCell(6).setCellValue("序列号");  
        nRow.createCell(7).setCellValue("购买时间"); 
        nRow.createCell(8).setCellValue("领取时间");  
        nRow.createCell(9).setCellValue("使用状态"); 
        nRow.createCell(10).setCellValue("编号");  
        nRow.createCell(11).setCellValue("备注");
 
        int company_id = Integer.parseInt(request.getParameter("company_id"));
        
       List<Assets> assetslist =  assetsService.findByCompanyIds(company_id);
       for (int i = 0; i < assetslist.size(); i++) {
           assets = (Assets) assetslist.get(i);
    	   Row mRow=sheet.createRow(i+2);
    	   mRow.createCell(0).setCellValue(assets.getUsers());  
           mRow.createCell(1).setCellValue(assets.getP_type()); 
           mRow.createCell(2).setCellValue(assets.getAmount());  
           mRow.createCell(3).setCellValue(assets.getModel()); 
           mRow.createCell(4).setCellValue(assets.getPrice());  
           mRow.createCell(5).setCellValue(assets.getConfigration()); 
           mRow.createCell(6).setCellValue(assets.getSerial_number());  
           mRow.createCell(7).setCellValue(assets.getBuy_time()); 
           mRow.createCell(8).setCellValue(assets.getReceive_time());  
           mRow.createCell(9).setCellValue(assets.getP_status()); 
           mRow.createCell(10).setCellValue(assets.getNumber());  
           mRow.createCell(11).setCellValue(assets.getRemark());  
       }
       
       
       String fileName = "西普数据固定资产表";
       ByteArrayOutputStream os = new ByteArrayOutputStream();
       workbook.write(os);
       byte[] content = os.toByteArray();
       InputStream is = new ByteArrayInputStream(content);
       // 设置response参数，可以打开下载页面
       response.reset();
       response.setContentType("application/vnd.ms-excel;charset=utf-8");
       response.setHeader("Content-Disposition", "attachment;filename="
           + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
       ServletOutputStream out = response.getOutputStream();
       BufferedInputStream bis = null;
       BufferedOutputStream bos = null;
  
       try {
         bis = new BufferedInputStream(is);
         bos = new BufferedOutputStream(out);
         byte[] buff = new byte[2048];
         int bytesRead;
         // Simple read/write loop.
         while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
           bos.write(buff, 0, bytesRead);
         }
       } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
       } finally {
         if (bis != null)
           bis.close();
         if (bos != null)
           bos.close();
       }
       
/**
 *  	不弹出下载框下载
 *     //第六步:保存  
       OutputStream os=new FileOutputStream(new File("F:\\testPOI22.xls"));  
       workbook.write(os);  
         
       //第七步:关闭  
       os.close();  

 *      
 */

        //第六步:保存  
       // OutputStream os=new FileOutputStream(new File("F:\\"+company_id+"西普数据.xls")); 
//          OutputStream os=new FileOutputStream(new File(company_id+"西普数据.xls")); 
//        workbook.write(os);  
//        //第七步:关闭  
//        os.close();  
//        
//        response.setContentType("application/x-download");
//        response.addHeader("Content-Disposition", "attachment;filename="+os);
//        OutputStream out = response.getOutputStream();
        //workbook.write(os);  
        //第七步:关闭  
       // os.close(); 
 //       JOptionPane.showMessageDialog(null,"导出成功!");
//		PrintWriter out = response.getWriter();
//		out.println("  <script type='text/javascript'> alert('密码修改成功！')</script>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
//        uri = "/detail/public/right.jsp";
//        request.getRequestDispatcher(uri).forward(request, response);
    }

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}

}
