/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package occult.safejar;

/**
 *
 * @author ariel
 */
import com.jcraft.jsch.*;

public class SafeJar {

    public static void main(String[] args) {

        String user = "ulysses";
        String password = "Iliad4#";
        String host = "192.168.53.127";
        int port = 22;

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("Connected to " + host);

            // Create a directory named "test" on the remote server
            String command = "mkdir test";
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            channel.connect();
            channel.disconnect();

            session.disconnect();
            System.out.println("Disconnected from " + host);

        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
}
