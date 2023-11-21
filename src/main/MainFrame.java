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

//Java��GUI����Ļ���˼·����JFrameΪ������������Ļ��window�Ķ����ܹ���󻯡���С�����رա�
@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
	//JMenuBar�Ĺ����� java.awt.MenuBar������ͬ��������������һ��ˮƽ�˵�����������Ա����ʹ��JMenuBar���add������˵�������Ӳ˵���
	//JMenuBarΪ��ӵ����еĲ˵�����һ������������������ݸ��������˵�������������ʾ��
	JMenuBar  menubar = new JMenuBar();//JMenuBar���˵���
	
	//��һ�������У����Ǿ�����Ҫ��������Ӳ˵������� Java ����һ��������������ʵ�ֵģ�������JMenuBar��JMenu��JMenuItem���ֱ��Ӧ�˵������˵��Ͳ˵��
	JMenu   userMenu = new JMenu("����Ա����");//JMenu���˵�
	JMenuItem  teacherMenuItem = new JMenuItem("����Ա�޸�");//JMenuItem���˵���
	JMenuItem  addTeacherMenuItem = new JMenuItem("��ӹ���Ա");
	JMenu  queryTeacherMenuItem = new JMenu("����Ա��ѯ");
		JMenuItem  query1TeacherMenuItem = new JMenuItem("�ֲ���ѯ");
		JMenuItem  query2TeacherMenuItem = new JMenuItem("ȫ�ֲ�ѯ");
	JMenuItem  deleteTeacherMenuItem = new JMenuItem("ɾ������Ա");
	JMenuItem  adminTeacherMenuItem = new JMenuItem("�޸�Ȩ��");
	//JMenuItem  passMenuItem = new JMenuItem("�޸�����");
	//JMenuItem  exitMenuItem = new JMenuItem("�˳�ϵͳ");

	JMenu   gradeMenu = new JMenu("��������");
	//JMenuItem inputMenuItem = new JMenuItem("�ɼ�¼��");
	//JMenuItem queryMenuItem = new JMenuItem("�ɼ���ѯ");
	JMenuItem globalManagerMenuIter = new JMenuItem("�������");

	/*JMenu   managerMenu = new JMenu("ȫ�ֹ���");
	JMenuItem managerMenuItem = new JMenuItem("�������");*/
	
	/*JMenu   courseMenu = new JMenu("�γ̹���");
	JMenuItem courseCatalogMenuItem = new JMenuItem("����Ŀ¼��ѯ");
	JMenuItem studentListMenuItem = new JMenuItem("�γ�������ѯ");*/
	
	JMenu   studentMenu = new JMenu("Ѳ��Ա����");
	JMenuItem addStudentMenuItem = new JMenuItem("���Ѳ��Ա");
	JMenuItem updateStudentMenuItem = new JMenuItem("Ѳ��Ա�޸�");
	JMenu queryStudentMenuItem = new JMenu("Ѳ��Ա��ѯ");
		JMenuItem query1StudentMenuItem = new JMenuItem("�ֲ���ѯ");
		JMenuItem query2StudentMenuItem = new JMenuItem("ȫ����ѯ");
	JMenuItem deleteStudentMenuItem = new JMenuItem("ɾ��Ѳ��Ա");
	
	JMenu   otherMenu = new JMenu("����");
	JMenuItem otherFirstMenuItem = new JMenuItem("�޸�����");
	JMenuItem otherSecondMenuItem = new JMenuItem("�˳�ϵͳ");
	
	JMenu   aboutSystemMenu = new JMenu("����ϵͳ");
	JMenuItem aboutMenuItem = new JMenuItem("����");
	JMenuItem helpMenuItem = new JMenuItem("����");
	
	//JLabel(String text) ��������ָ���ı��� JLabelʵ��
	JLabel  welcomeLabel = new JLabel("����Ѳ�����ϵͳ");
	
	TeacherDialog teacherDialog;	//�������д�����û������еĽ�ʦ����ģ��
	AddTeacherDialog addTeacherDialog;
	QueryTeacherDialog queryTeacherDialog;
	Query1TeacherDialog query1TeacherDialog;
	DeleteTeacherDialog deleteTeacherDialog;
	UpdateInputPower updateInputPower;
	//StudentManageSystem managerDialog;
	QueryStudentScore course;	//�������д���ǳɼ������еĳɼ���ѯģ��
	QueryStudentDialog queryStudentDialog;	//�������д����ѧ�������е�ѧ����Ϣ��ѯģ��
	Query2StudentDialog query2StudentDialog;
	DeleteStudentDialog deleteStudentDialog;
	StudentManageSystem globalManage;
	UpdateStudentDialog updateStudentDialog;	//�������д����ѧ�������е�ѧ����Ϣ�޸�ģ��
	UpdatePassDilog updatePassword;	//�������д�����û������е������޸�ģ��
	AddStudentDialog addStudentDialog;	//�������д����ѧ�������е�ѧ����Ϣ���ģ��
	public MainFrame(){
		this.setTitle("����Ѳ�����ϵͳ---����Ա����");
		//�������˵�
		this.setJMenuBar(menubar);
		menubar.add(userMenu);
		menubar.add(studentMenu);
		//menubar.add(managerMenu);
		menubar.add(gradeMenu);
		//menubar.add(courseMenu);
		menubar.add(otherMenu);
		menubar.add(aboutSystemMenu);
		
		//�����ʦ�û�����˵�
		userMenu.add(addTeacherMenuItem);
		userMenu.add(teacherMenuItem);
		userMenu.add(queryTeacherMenuItem);
			queryTeacherMenuItem.add(query1TeacherMenuItem);
			queryTeacherMenuItem.add(query2TeacherMenuItem);
		userMenu.add(deleteTeacherMenuItem);
		userMenu.add(adminTeacherMenuItem);
		//userMenu.add(passMenuItem);
		//userMenu.add(exitMenuItem);
		//����ѧ������˵�
		studentMenu.add(addStudentMenuItem);
		studentMenu.add(updateStudentMenuItem);
		studentMenu.add(queryStudentMenuItem);
			queryStudentMenuItem.add(query1StudentMenuItem);
			queryStudentMenuItem.add(query2StudentMenuItem);
		studentMenu.add(deleteStudentMenuItem);
		
		//managerMenu.add(managerMenuItem);
		
		//����ɼ�����˵�
		//gradeMenu.add(inputMenuItem);
		//gradeMenu.add(queryMenuItem);
		gradeMenu.add(globalManagerMenuIter);
		//����γ̹���˵�
		//courseMenu.add(courseCatalogMenuItem);
		//courseMenu.add(studentListMenuItem);
		//�����˵�
		otherMenu.add(otherFirstMenuItem);
		otherMenu.add(otherSecondMenuItem);
		
		aboutSystemMenu.add(aboutMenuItem);
		aboutSystemMenu.add(helpMenuItem);

		
		//���컶ӭҳ��
		welcomeLabel.setFont(new java.awt.Font("DialogInput", 1, 48));//����ָ�����ơ���ʽ�Ͱ�ֵ��С������һ���� Font��
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.blue);
		this.getContentPane().add(welcomeLabel);

		//Ϊ���˵�ע�������
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

			
		//��ʾϵͳ������
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		//���˵�����
		if(e.getSource()==teacherMenuItem){  //��ʦ�û�����
			//������ʦ�������
			 teacherDialog=new TeacherDialog(this);
		}else if(e.getSource()==addTeacherMenuItem){//��ʦ���
			//������ʦ��ӽ���
			addTeacherDialog = new AddTeacherDialog(this);
		}else if(e.getSource()==query1TeacherMenuItem){//�ֲ���ѯ
			//������ʦ��ѯ����
			queryTeacherDialog = new QueryTeacherDialog(this);
		}else if(e.getSource()==query2TeacherMenuItem){//ȫ�ֲ�ѯ
			//������ʦ��ѯ����
			query1TeacherDialog = new Query1TeacherDialog(this);
		}else if(e.getSource()==deleteTeacherMenuItem){//��ʦɾ��
			//������ʦɾ������
			deleteTeacherDialog = new DeleteTeacherDialog(this);
		}else if(e.getSource()==adminTeacherMenuItem){//�޸�Ȩ��
			//������ʦȨ�޽���
			updateInputPower = new UpdateInputPower(this);
		}else if(e.getSource()==otherFirstMenuItem){//�޸�����
			//�����޸��������
			updatePassword =new UpdatePassDilog(this);
			}	
		else if(e.getSource()==otherSecondMenuItem){//�˳�ϵͳ
			if(JOptionPane.showConfirmDialog(this, "ȷ��Ҫ�˳�ϵͳ��","�˳�",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(0);
			}			
		}else if(e.getSource()==globalManagerMenuIter){//�ɼ���ѯ
			//�����ɼ���ѯ���
			globalManage = new StudentManageSystem(this);
			
		}else if(e.getSource()==addStudentMenuItem){//���ѧ��
			//����ѧ���������
				addStudentDialog=new AddStudentDialog(this);
		}else if(e.getSource()==updateStudentMenuItem){//ѧ���޸�
			//����ѧ���޸Ľ���
			updateStudentDialog =new UpdateStudentDialog(this);
			//������ʦ�������
		}else if(e.getSource()==query1StudentMenuItem){//�ֲ���ѯ
			//����ѧ����ѯ����
			queryStudentDialog = new QueryStudentDialog(this);
		}else if(e.getSource()==query2StudentMenuItem){//ȫ�ֲ�ѯ
			//����ѧ����ѯ����
			query2StudentDialog = new Query2StudentDialog(this);
		}else if(e.getSource()==deleteStudentMenuItem){//ѧ����ѯ
			//����ѧ��ɾ������
			deleteStudentDialog = new DeleteStudentDialog(this);
		}else if(e.getSource()==aboutMenuItem){
			JOptionPane.showMessageDialog(null,"����Ѳ�����ϵͳ");
		}else if(e.getSource()==helpMenuItem){
			JOptionPane.showMessageDialog(null,
					"����Ѳ�����ϵͳ"
					);
		}
		
	}
}
