package View;

import javax.swing.*;
import java.awt.*;

public class EmployeeDashboard extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public EmployeeDashboard(JPanel contentPanel, CardLayout cardLayout) {
        this.contentPanel = contentPanel;
        this.cardLayout = cardLayout;

        setLayout(null);
        setPreferredSize(new Dimension(669, 526));
        setBackground(new Color(245, 245, 245));

        JPanel panel = new JPanel();
        panel.setBounds(58, 53, 567, 428);
        add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Emp Detail");
        btnNewButton.setBounds(167, 101, 120, 30);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(e -> {
            cardLayout.show(contentPanel, "EmployeeDetailsUserView");
        });
    }
}
