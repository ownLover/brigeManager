package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Dialog.AddStudentDialog;
import Dialog.AddTeacherDialog;
import Dialog.DeleteStudentDialog;
import Dialog.DeleteTeacherDialog;
import Dialog.QueryStudentScore;
import Dialog.QueryTeacherDialog;
import Dialog.Query1TeacherDialog;
import Dialog.Query2StudentDialog;
import Dialog.QueryStudentDialog;
import Dialog.TeacherDialog;
import Dialog.UpdateInputPower;
import Dialog.UpdatePassDilog;
import Dialog.UpdateStudentDialog;
import StudentManageSystem.StudentManageSystem;

//Java的GUI程序的基本思路是以JFrame为基础，它是屏幕上window的对象，能够最大化、最小化、关闭。
@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
	//JMenuBar的功能与 java.awt.MenuBar基本相同，都是用来创建一个水平菜单栏。开发人员可以使用JMenuBar类的add方法向菜单栏中添加菜单，
	//JMenuBar为添加到其中的菜单分配一个整数索引，并会根据该索引将菜单从左到右依次显示。
	JMenuBar  menubar = new JMenuBar();//JMenuBar：菜单条
	
	//在一个窗口中，我们经常需要给窗口添加菜单条。在 Java 中这一部分是由三个类实现的，它们是JMenuBar、JMenu和JMenuItem，分别对应菜单条、菜单和菜单项。
	JMenu   userMenu = new JMenu("管理员管理");//JMenu：菜单
	JMenuItem  teacherMenuItem = new JMenuItem("管理员修改");//JMenuItem：菜单项
	JMenuItem  addTeacherMenuItem = new JMenuItem("添加管理员");
	JMenu  queryTeacherMenuItem = new JMenu("管理员查询");
		JMenuItem  query1TeacherMenuItem = new JMenuItem("局部查询");
		JMenuItem  query2TeacherMenuItem = new JMenuItem("全局查询");
	JMenuItem  deleteTeacherMenuItem = new JMenuItem("删除管理员");
	JMenuItem  adminTeacherMenuItem = new JMenuItem("修改权限");
	//JMenuItem  passMenuItem = new JMenuItem("修改密码");
	//JMenuItem  exitMenuItem = new JMenuItem("退出系统");

	JMenu   gradeMenu = new JMenu("桥梁管理");
	//JMenuItem inputMenuItem = new JMenuItem("成绩录入");
	//JMenuItem queryMenuItem = new JMenuItem("成绩查询");
	JMenuItem globalManagerMenuIter = new JMenuItem("点击管理");

	/*JMenu   managerMenu = new JMenu("全局管理");
	JMenuItem managerMenuItem = new JMenuItem("点击管理");*/
	
	/*JMenu   courseMenu = new JMenu("课程管理");
	JMenuItem courseCatalogMenuItem = new JMenuItem("开课目录查询");
	JMenuItem studentListMenuItem = new JMenuItem("课程名单查询");*/
	
	JMenu   studentMenu = new JMenu("巡查员管理");
	JMenuItem addStudentMenuItem = new JMenuItem("添加巡查员");
	JMenuItem updateStudentMenuItem = new JMenuItem("巡查员修改");
	JMenu queryStudentMenuItem = new JMenu("巡查员查询");
		JMenuItem query1StudentMenuItem = new JMenuItem("局部查询");
		JMenuItem query2StudentMenuItem = new JMenuItem("全部查询");
	JMenuItem deleteStudentMenuItem = new JMenuItem("删除巡查员");
	
	JMenu   otherMenu = new JMenu("其他");
	JMenuItem otherFirstMenuItem = new JMenuItem("修改密码");
	JMenuItem otherSecondMenuItem = new JMenuItem("退出系统");
	
	JMenu   aboutSystemMenu = new JMenu("关于系统");
	JMenuItem aboutMenuItem = new JMenuItem("关于");
	JMenuItem helpMenuItem = new JMenuItem("帮助");
	
	//JLabel(String text) 创建具有指定文本的 JLabel实例
	JLabel  welcomeLabel = new JLabel("桥梁巡查管理系统");
	
	TeacherDialog teacherDialog;	//这个类里写的是用户管理中的教师管理模块
	AddTeacherDialog addTeacherDialog;
	QueryTeacherDialog queryTeacherDialog;
	Query1TeacherDialog query1TeacherDialog;
	DeleteTeacherDialog deleteTeacherDialog;
	UpdateInputPower updateInputPower;
	//StudentManageSystem managerDialog;
	QueryStudentScore course;	//这个类里写的是成绩管理中的成绩查询模块
	QueryStudentDialog queryStudentDialog;	//这个类里写的是学生管理中的学生信息查询模块
	Query2StudentDialog query2StudentDialog;
	DeleteStudentDialog deleteStudentDialog;
	StudentManageSystem globalManage;
	UpdateStudentDialog updateStudentDialog;	//这个类里写的是学生管理中的学生信息修改模块
	UpdatePassDilog updatePassword;	//这个类里写的是用户管理中的密码修改模块
	AddStudentDialog addStudentDialog;	//这个类里写的是学生管理中的学生信息添加模块
	public MainFrame(){
		this.setTitle("桥梁巡查管理系统---管理员界面");
		//构造主菜单
		this.setJMenuBar(menubar);
		menubar.add(userMenu);
		menubar.add(studentMenu);
		//menubar.add(managerMenu);
		menubar.add(gradeMenu);
		//menubar.add(courseMenu);
		menubar.add(otherMenu);
		menubar.add(aboutSystemMenu);
		
		//构造教师用户管理菜单
		userMenu.add(addTeacherMenuItem);
		userMenu.add(teacherMenuItem);
		userMenu.add(queryTeacherMenuItem);
			queryTeacherMenuItem.add(query1TeacherMenuItem);
			queryTeacherMenuItem.add(query2TeacherMenuItem);
		userMenu.add(deleteTeacherMenuItem);
		userMenu.add(adminTeacherMenuItem);
		//userMenu.add(passMenuItem);
		//userMenu.add(exitMenuItem);
		//构造学生管理菜单
		studentMenu.add(addStudentMenuItem);
		studentMenu.add(updateStudentMenuItem);
		studentMenu.add(queryStudentMenuItem);
			queryStudentMenuItem.add(query1StudentMenuItem);
			queryStudentMenuItem.add(query2StudentMenuItem);
		studentMenu.add(deleteStudentMenuItem);
		
		//managerMenu.add(managerMenuItem);
		
		//构造成绩管理菜单
		//gradeMenu.add(inputMenuItem);
		//gradeMenu.add(queryMenuItem);
		gradeMenu.add(globalManagerMenuIter);
		//构造课程管理菜单
		//courseMenu.add(courseCatalogMenuItem);
		//courseMenu.add(studentListMenuItem);
		//其他菜单
		otherMenu.add(otherFirstMenuItem);
		otherMenu.add(otherSecondMenuItem);
		
		aboutSystemMenu.add(aboutMenuItem);
		aboutSystemMenu.add(helpMenuItem);

		
		//构造欢迎页面
		welcomeLabel.setFont(new java.awt.Font("DialogInput", 1, 48));//根据指定名称、样式和磅值大小，创建一个新 Font。
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.blue);
		this.getContentPane().add(welcomeLabel);

		//为主菜单注册监听器
		teacherMenuItem.addActionListener(this);
		addTeacherMenuItem.addActionListener(this);
		query1TeacherMenuItem.addActionListener(this);
		query2TeacherMenuItem.addActionListener(this);
		deleteTeacherMenuItem.addActionListener(this);
		adminTeacherMenuItem.addActionListener(this);
		//passMenuItem.addActionListener(this);
		//exitMenuItem.addActionListener(this);
		//managerMenuItem.addActionListener(this);
		
		addStudentMenuItem.addActionListener(this);
		updateStudentMenuItem.addActionListener(this);
		query1StudentMenuItem.addActionListener(this);
		query2StudentMenuItem.addActionListener(this);
		deleteStudentMenuItem.addActionListener(this);
		
		//inputMenuItem.addActionListener(this);
		//queryMenuItem.addActionListener(this);
		globalManagerMenuIter.addActionListener(this);
		
		//courseCatalogMenuItem.addActionListener(this);
		//studentListMenuItem.addActionListener(this);
		
		otherFirstMenuItem.addActionListener(this);
		otherSecondMenuItem.addActionListener(this);
		
		aboutMenuItem.addActionListener(this);
		helpMenuItem.addActionListener(this);

			
		//显示系统主界面
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		//主菜单控制
		if(e.getSource()==teacherMenuItem){  //教师用户管理
			//创建教师管理界面
			 teacherDialog=new TeacherDialog(this);
		}else if(e.getSource()==addTeacherMenuItem){//教师添加
			//创建教师添加界面
			addTeacherDialog = new AddTeacherDialog(this);
		}else if(e.getSource()==query1TeacherMenuItem){//局部查询
			//创建教师查询界面
			queryTeacherDialog = new QueryTeacherDialog(this);
		}else if(e.getSource()==query2TeacherMenuItem){//全局查询
			//创建教师查询界面
			query1TeacherDialog = new Query1TeacherDialog(this);
		}else if(e.getSource()==deleteTeacherMenuItem){//教师删除
			//创建教师删除界面
			deleteTeacherDialog = new DeleteTeacherDialog(this);
		}else if(e.getSource()==adminTeacherMenuItem){//修改权限
			//创建教师权限界面
			updateInputPower = new UpdateInputPower(this);
		}else if(e.getSource()==otherFirstMenuItem){//修改密码
			//创建修改密码界面
			updatePassword =new UpdatePassDilog(this);
			}	
		else if(e.getSource()==otherSecondMenuItem){//退出系统
			if(JOptionPane.showConfirmDialog(this, "确认要退出系统？","退出",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(0);
			}			
		}else if(e.getSource()==globalManagerMenuIter){//成绩查询
			//创建成绩查询面板
			globalManage = new StudentManageSystem(this);
			
		}else if(e.getSource()==addStudentMenuItem){//添加学生
			//创建学生管理界面
				addStudentDialog=new AddStudentDialog(this);
		}else if(e.getSource()==updateStudentMenuItem){//学生修改
			//创建学生修改界面
			updateStudentDialog =new UpdateStudentDialog(this);
			//创建教师管理界面
		}else if(e.getSource()==query1StudentMenuItem){//局部查询
			//创建学生查询界面
			queryStudentDialog = new QueryStudentDialog(this);
		}else if(e.getSource()==query2StudentMenuItem){//全局查询
			//创建学生查询界面
			query2StudentDialog = new Query2StudentDialog(this);
		}else if(e.getSource()==deleteStudentMenuItem){//学生查询
			//创建学生删除界面
			deleteStudentDialog = new DeleteStudentDialog(this);
		}else if(e.getSource()==aboutMenuItem){
			JOptionPane.showMessageDialog(null,"桥梁巡查管理系统");
		}else if(e.getSource()==helpMenuItem){
			JOptionPane.showMessageDialog(null,
					"桥梁巡查管理系统"
					);
		}
		
	}
}
