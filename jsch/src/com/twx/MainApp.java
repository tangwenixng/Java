package com.twx;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
public class MainApp {
	public static void main(String[] args) throws Exception {
		MainApp.sshSftp("192.168.1.120", "twx", "qwer", 22);
//		Test1.sshSftp2("192.168.1.120", "twx", 22,
//				"D:\\eclipse_java_workspace\\password\\id_rsa", "");
	}

	/**
	 * ����JSch��ʵ��SFTP���ء��ϴ��ļ�(�û������뷽ʽ��½)
	 * 
	 * @param ip
	 *            ����IP
	 * @param user
	 *            ������½�û���
	 * @param psw
	 *            ������½����
	 * @param port
	 *            ����ssh2��½�˿ڣ����ȡĬ��ֵ(Ĭ��ֵ22)����-1
	 * 
	 */
	public static void sshSftp(String ip, String user, String psw, int port)
			throws Exception {
		System.out.println("��ʼ�û������뷽ʽ��½");
		Session session = null;

		JSch jsch = new JSch();

		if (port <= 0) {
			// ���ӷ�����������Ĭ�϶˿�
			session = jsch.getSession(user, ip);
		} else {
			// ����ָ���Ķ˿����ӷ�����
			session = jsch.getSession(user, ip, port);
		}

		// ������������Ӳ��ϣ����׳��쳣
		if (session == null) {
			throw new Exception("session is null");
		}

		// ���õ�½����������
		session.setPassword(psw);// ��������
		// ���õ�һ�ε�½��ʱ����ʾ����ѡֵ��(ask | yes | no)
		session.setConfig("StrictHostKeyChecking", "no");
		// ���õ�½��ʱʱ��
		session.connect(30000);

		sftp(session, "jplay.sh","F:/sft/twx/aa.sh.txt");
		System.out.println("sftp�ɹ�");

	}

	/**
	 * ����JSch��ʵ��SFTP���ء��ϴ��ļ�(��Կ��ʽ��½)
	 * 
	 * @param ip
	 *            ����IP
	 * @param user
	 *            ������½�û���
	 * @param port
	 *            ����ssh2��½�˿ڣ����ȡĬ��ֵ(Ĭ��ֵ22)����-1
	 * @param privateKey
	 *            ��Կ�ļ�·��
	 * @param passphrase
	 *            ��Կ������
	 * 
	 */
	public static void sshSftp2(String ip, String user, int port,
			String privateKey, String passphrase) throws Exception {
		System.out.println("��ʼ��Կ��ʽ��½");
		Session session = null;

		JSch jsch = new JSch();

		// ������Կ������
		// ֧����Կ�ķ�ʽ��½��ֻ����jsch.getSession֮ǰ����һ����Կ�������Ϣ�Ϳ�����
		if (privateKey != null && !"".equals(privateKey)) {
			if (passphrase != null && "".equals(passphrase)) {
				// ���ô��������Կ
				jsch.addIdentity(privateKey, passphrase);
			} else {
				// ���ò����������Կ
				jsch.addIdentity(privateKey);
			}
		}

		if (port <= 0) {
			// ���ӷ�����������Ĭ�϶˿�
			session = jsch.getSession(user, ip);
		} else {
			// ����ָ���Ķ˿����ӷ�����
			session = jsch.getSession(user, ip, port);
		}

		// ������������Ӳ��ϣ����׳��쳣
		if (session == null) {
			throw new Exception("session is null");
		}

		// ���õ�һ�ε�½��ʱ����ʾ����ѡֵ��(ask | yes | no)
		session.setConfig("StrictHostKeyChecking", "no");
		// ���õ�½��ʱʱ��
		session.connect(30000);

		sftp(session, "sfsa.sh","sdafaf");
		System.out.println("sftp�ɹ�");
	}

	private static void sftp(Session session, String uploadFileName,String myShell)
			throws Exception {
		Channel channel = null;
		try {
			// ����sftpͨ��ͨ��
			channel = (Channel) session.openChannel("sftp");
			channel.connect(1000);
			ChannelSftp sftp = (ChannelSftp) channel;

			// ���������ָ�����ļ���
			sftp.cd("/home/twx");

			// �г�������ָ�����ļ��б�
			Vector v = sftp.ls("*.sh");
			for (int i = 0; i < v.size(); i++) {
				System.out.println(v.get(i));
			}

			// ���´���ʵ�ִӱ����ϴ�һ���ļ��������������Ҫʵ�����أ��Ի��������Ϳ�����
			OutputStream outstream = sftp.put(uploadFileName);
			InputStream instream = new FileInputStream(new File(
					myShell));
			//InputStream instream = new FileInputStream(myShell);

			byte b[] = new byte[1024];
			int n;
			while ((n = instream.read(b)) != -1) {
				outstream.write(b, 0, n);
			}

			outstream.flush();
			outstream.close();
			instream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.disconnect();
			channel.disconnect();
		}

	}
	
}
