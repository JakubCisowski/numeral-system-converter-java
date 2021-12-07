package pl.polsl.views;

import pl.polsl.models.ConversionSet;
import pl.polsl.models.Registry;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Class representing registry table dialog view.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class SwingRegistryTableDialog extends JDialog
{
	/**
	 * Class constructor responsible for populating table in dialog and displaying it.
	 *
	 * @param frame GUI application main frame.
	 * @param registry Registry set for table rendering.
	 */
	public SwingRegistryTableDialog(JFrame frame, Registry registry) {
		super( frame, "Registry records", true );

		Vector columns = new Vector();
		Vector rows = new Vector();
		Vector Header = new Vector();

		columns.add("col1");
		columns.add("col2");
		columns.add("col3");
		columns.add("col4");
		Header.add("NUMBER 1");
		Header.add("SYSTEM");
		Header.add("NUMBER 2");
		Header.add("SYSTEM");
		rows.add(Header);

		for (ConversionSet set : registry.getRegistry()) {
			Vector conversionRow = new Vector();
			conversionRow.add(set.getNumberValue());
			conversionRow.add("(" + set.getOriginalSystem() + ")");
			conversionRow.add(set.getConversionResult());
			conversionRow.add("(" + set.getTargetSystem()+ ")");
			rows.add(conversionRow);
		}

		JTable table = new JTable(rows, columns);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		add(new JScrollPane(table));
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(table);
		this.pack();
		this.show();
	}
}