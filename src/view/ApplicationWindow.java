package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {
	private final JFrame frame;
	private Panel panel;
	private InternalPanel internalPanel;
	private Menu menu;
	private Bottom bottom;
	private MenuRooms room;
	private final JLabel labClose;
	private final JLabel labMin;
	private final JLabel labLogo;
	private JLabel labHome;
	private final JLabel labUsers;
	private final JLabel labroom;
	private final JLabel labSettings;
	private int xMouse;
	private int yMouse;

	/**
	 * Create the frame.
	 */
	public ApplicationWindow() {
		this.frame = new JFrame();
		this.labClose = new JLabel();
		this.labMin = new JLabel();
		this.labLogo = new JLabel();
		this.labHome = new JLabel("Home");
		this.labUsers = new JLabel("Manage Users");
		this.labroom = new JLabel("Manage Rooms");
		this.labSettings = new JLabel("Choose a Room");

		initFrame();
		initComponents();
		iconsConfig();
		menuConfig();
		frameListener();
		panelListener();

		BottomItems itemRights = new BottomItems();
		bottom.add(itemRights.createLabName());
		bottom.add(itemRights.createTime());

		JLabel homePan = new JLabel();
		homePan.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/home_pan.png")), 450, 450));
		homePan.setHorizontalAlignment(SwingConstants.CENTER);
		homePan.setVerticalAlignment(SwingConstants.CENTER);
		homePan.setBounds(50, 0, 500, 500);
		internalPanel.add(homePan);

		frame.getContentPane().add(panel);
		panel.add(internalPanel);
		panel.add(menu);
		panel.add(bottom);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initialize the main frame
	 */
	public void initFrame() {
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getPreferredSize().width / 2,
				screenSize.height / 2 - frame.getPreferredSize().height / 2);
	}

	/**
	 * Initialize the frame components
	 */
	public void initComponents() {
		panel = new Panel();
		internalPanel = new InternalPanel();
		menu = new Menu();
		bottom = new Bottom();
		room = new MenuRooms();

	}

	/**
	 * Close and minimize icons
	 */
	public void iconsConfig() {
		labClose.setHorizontalAlignment(SwingConstants.CENTER);
		labClose.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/close_in.png")), 18, 18));
		labClose.setBounds(770, 2, 20, 20);
		labClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labClose.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/close.png")), 18, 18));
				labClose.setBounds(770, 2, 20, 20);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labClose.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/close_in.png")), 18, 18));
				labClose.setBounds(770, 2, 20, 20);
			}
		});
		panel.add(labClose);

		labMin.setHorizontalAlignment(SwingConstants.CENTER);
		labMin.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize.png")), 18, 18));
		labMin.setBounds(740, 2, 20, 20);
		labMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labMin.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize_in.png")), 18, 18));
				labMin.setBounds(740, 2, 20, 20);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labMin.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize.png")), 18, 18));
				labMin.setBounds(740, 2, 20, 20);
			}
		});
		panel.add(labMin);
	}

	/**
	 * Add listeners to the frame to change back the minimize icon to its original
	 * state
	 */
	public void frameListener() {
		frame.addWindowListener((WindowListener) new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				labMin.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/minimize.png")), 18, 18));
				labMin.setBounds(740, 2, 20, 20);
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	/**
	 * Add listeners to move the undecorated frame when the mouse is dragged
	 */
	public void panelListener() {
		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getLocation().x + e.getX() - xMouse, frame.getLocation().y + e.getY() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
	}

	/**
	 * Configuration of the menu items
	 */
	public void menuConfig() {

		// App Logo
		labLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labLogo.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/logo.png")), 140, 140));
		labLogo.setBounds(40, 0, 140, 140);
		menu.add(labLogo);
		menu.add(labLogo);

		labHome = new JLabel("Home");
		labHome.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/home.png")), 40, 40));
		labHome.setHorizontalAlignment(SwingConstants.LEFT);
		labHome.setVerticalAlignment(SwingConstants.BOTTOM);
		labHome.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labHome.setBounds(5, 170, 215, 40);
		labHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labHome.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labHome.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();
				JLabel homePan = new JLabel();
				homePan.setIcon(IconsResize.getScaledImage(
						new ImageIcon(ApplicationWindow.class.getResource("/icons/home_pan.png")), 450, 450));
				homePan.setHorizontalAlignment(SwingConstants.CENTER);
				homePan.setVerticalAlignment(SwingConstants.CENTER);
				homePan.setBounds(50, 0, 500, 500);
				internalPanel.add(homePan);

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labHome);

		labUsers.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/user.png")), 40, 40));
		labUsers.setHorizontalAlignment(SwingConstants.LEFT);
		labUsers.setVerticalAlignment(SwingConstants.BOTTOM);
		labUsers.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labUsers.setBounds(5, 230, 215, 40);
		labUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labUsers.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labUsers.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsers home = new MenuUsers();
				internalPanel.removeAll();
				internalPanel.add(home.createPanUsers());

				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labUsers);

		labroom.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/room.png")), 40, 40));
		labroom.setHorizontalAlignment(SwingConstants.LEFT);
		labroom.setVerticalAlignment(SwingConstants.BOTTOM);
		labroom.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labroom.setBounds(5, 290, 215, 40);
		labroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labroom.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labroom.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				internalPanel.removeAll();
				internalPanel.add(room.createPanRooms());
				frame.pack();
				frame.repaint();
			}
		});
		menu.add(labroom);

		labSettings.setIcon(IconsResize
				.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource("/icons/choose.png")), 40, 40));
		labSettings.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
		labSettings.setHorizontalAlignment(SwingConstants.LEFT);
		labSettings.setVerticalAlignment(SwingConstants.BOTTOM);
		labSettings.setBounds(5, 350, 215, 40);
		labSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labSettings.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labSettings.setForeground(Color.getColor(null));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				MenuSelection settings = new MenuSelection();
				internalPanel.removeAll();

				internalPanel.add(settings.createLabel());
				internalPanel.add(settings.createCombo());

				frame.pack();
				frame.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		menu.add(labSettings);

		MenuSeparators.lineSeparator(menu);

	}

}
