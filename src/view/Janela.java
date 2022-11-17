package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import entidades.Author;
import entidades.Book;
import entidades.BooksAuthor;
import entidades.Publisher;

@SuppressWarnings("serial")
public class Janela extends JFrame implements View{
	
	JTabbedPane  jTab= new JTabbedPane();
	JPanel buscaPanel = new JPanel();
	JPanel addPanel = new JPanel();
	JPanel editPanel = new JPanel();
	JPanel removePanel = new JPanel();
	
	String[] authorNames = new String[] {"Nome", "Sobrenome"};
	List<Author> authors = new ArrayList<>();
	DefaultTableModel dtmAuthor = new DefaultTableModel(authorNames, 0);
	String[] publisherNames = new String [] {"Nome","Website"};
	List<Publisher> publishers = new ArrayList<>();
	DefaultTableModel dtmPublisher = new DefaultTableModel(publisherNames, 0);
	String[] booksNames = new String[] {"Título", "Preco"};
	List<Book> books = new ArrayList<>();
	DefaultTableModel dtmBook = new DefaultTableModel(booksNames,0);
	String[] booksAuthorName = new String [] {"Autor", "Título"};
	List<BooksAuthor> booksAuthor = new ArrayList<>();
	DefaultTableModel dtmBooksAuthor = new DefaultTableModel(booksAuthorName,0);
	JTable tabela = new JTable();
	JScrollPane paneAuthor = new JScrollPane(tabela);
	
	JTextField fieldBusca = new JTextField();
	
	JButton buscaButton = new JButton("Busca");
	JRadioButton authorButton = new JRadioButton("Autores");
	JRadioButton bookButton = new JRadioButton("Livros");
	JRadioButton publisherButton = new JRadioButton("Editoras");
	JRadioButton booksAuthorButton = new JRadioButton("Livros de Autores");
	
	
	final static String AUTHOR = "Autor";
	final static String PUBLISHER = "Editora";
	final static String BOOK = "Livro";

	JPanel comboBoxPanelAdd = new JPanel();
	String comboBoxItemsAdd[] = {AUTHOR, PUBLISHER, BOOK };
	JComboBox<String> cbAdd = new JComboBox<>(comboBoxItemsAdd);
	
	JTextField txtNameAuthor  = new JTextField();
	JTextField txtFNameAuthor = new JTextField();
	JButton addAuthorButton = new JButton("Adicionar");
	
	JTextField txtNamePublisher = new JTextField();
	JTextField txtUrlPublisher = new JTextField();
	JButton addPublisherButton = new JButton("Adicionar");
	
	JTextField txtNameBook = new JTextField();
	JTextField txtIsbn = new JTextField();
	JTextField txtPrice = new JTextField();
	String[] publisherNames2 = new String [] {"Id","Editora"};
	List<Publisher> publishers2 = new ArrayList<>();
	DefaultTableModel dtmPublisher2 = new DefaultTableModel(publisherNames2, 0);
	JTable publisherTable = new JTable();
	JScrollPane publisherPane = new JScrollPane(publisherTable);
	String[] authorNames2 = new String[] {"Id","Autor"};
	List<Author> authors2 = new ArrayList<>();
	DefaultTableModel dtmAuthor2 = new DefaultTableModel(authorNames2, 0);	
	JButton addBookButton = new JButton("Adicionar");
	JTable authorTable = new JTable();
	JScrollPane authorPane = new JScrollPane(authorTable);

	final static String AUTHOR2 = "Autor";
	final static String PUBLISHER2 = "Editora";
	final static String BOOK2 = "Livro";
	
	JPanel comboBoxPanelEdit = new JPanel();
	String comboBoxItemsEdit[] = {AUTHOR2, PUBLISHER2, BOOK2 };
	JComboBox<String> cbEdit = new JComboBox<>(comboBoxItemsEdit);
	
	String[] authorNames3 = new String[] {"Id","Nome","Sobrenome"};
	List<Author> authors3 = new ArrayList<>();
	DefaultTableModel dtmAuthor3 = new DefaultTableModel(authorNames3,0);
	JTable authorTable2 = new JTable();
	JScrollPane authorPane2 = new JScrollPane(authorTable2);
	JTextField txtNameAuthor2  = new JTextField();
	JTextField txtFNameAuthor2 = new JTextField();
	JButton editAuthorButton = new JButton("Modificar");
	
	String[] publisherNames3 = new String[] {"ID","Editora","Website"};
	List<Publisher> publishers3 = new ArrayList<>();
	DefaultTableModel dtmPublisher3 = new DefaultTableModel(publisherNames3,0);
	JTable publisherTable2 = new JTable();
	JScrollPane publisherPane2 = new JScrollPane(publisherTable2);
	JTextField txtNamePublisher2 = new JTextField();
	JTextField txtUrlPublisher2 = new JTextField();
	JButton editPublisherButton = new JButton("Modificar");
	
	String[] bookNames2 = new String[] {"Id","Título","Price","aId"};
	List<Book> books2 = new ArrayList<>();
	DefaultTableModel dtmBook2 = new DefaultTableModel(bookNames2,0);
	JTable bookTable = new JTable();
	JScrollPane bookPane = new JScrollPane(bookTable);
	JTextField txtNameBook2 = new JTextField();
	JTextField txtPrice2 = new JTextField();
	JButton editBookButton = new JButton("Modificar");
	
	final static String AUTHOR3 = "Autor";
	final static String PUBLISHER3 = "Editora";
	final static String BOOK3 = "Livro";
	
	JPanel comboBoxPanelRemove = new JPanel();
	String comboBoxItemsRemove[] = {AUTHOR3, PUBLISHER3, BOOK3};
	JComboBox<String> cbRemove = new JComboBox<>(comboBoxItemsRemove);
	
	JTable authorTable3 = new JTable();
	JScrollPane authorPane3 = new JScrollPane(authorTable3);
	JButton removeAuthorButton = new JButton("Remover");
	
	JTable publisherTable3 = new JTable();
	JScrollPane publisherPane3 = new JScrollPane(publisherTable3);
	JButton removePublisherButton = new JButton("Remover");
	
	JTable bookTable2 = new JTable();
	JScrollPane bookPane2 = new JScrollPane(bookTable2);
	JButton removeBookButton = new JButton("Remover");
	
	
	@Override
	public void init() {
		
		jTab.add("Busca", buscaPanel);
		jTab.add("Adicionar", addPanel);
		jTab.add("Editar", editPanel);
		jTab.add("Remover", removePanel);
		add(jTab);
		
		buscaPanel.setLayout(new BorderLayout());
		
		JPanel panelRadio = new JPanel();
		panelRadio.setLayout(new BoxLayout(panelRadio, BoxLayout.LINE_AXIS));
		panelRadio.add(authorButton);
		authorButton.setSelected(true);
		panelRadio.add(bookButton);
		panelRadio.add(publisherButton);
		panelRadio.add(booksAuthorButton);
		ButtonGroup group = new ButtonGroup();
		group.add(authorButton);
		group.add(bookButton);
		group.add(publisherButton);
		group.add(booksAuthorButton);
		buscaPanel.add(panelRadio,BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
		panel1.add(fieldBusca);
		panel1.add(buscaButton);
		buscaPanel.add(panel1,BorderLayout.NORTH);
		
		JPanel tabelasPane = new JPanel();
		tabelasPane.setLayout(new BoxLayout(tabelasPane, BoxLayout.PAGE_AXIS));
		tabela.setModel(dtmAuthor);
		tabelasPane.add(paneAuthor);
		buscaPanel.add(tabelasPane,BorderLayout.SOUTH);	
		
		
		addPanel.setLayout(new BorderLayout());
		
		JPanel authorPanel = new JPanel();
		authorPanel.setLayout(new BoxLayout(authorPanel, BoxLayout.PAGE_AXIS));
		
		JPanel namePanel = new JPanel();
		namePanel.setMaximumSize(new Dimension(1000,25));
		namePanel.setLayout(new BoxLayout(namePanel,BoxLayout.LINE_AXIS));
		JLabel labelName = new JLabel("Nome: ");
		namePanel.add(labelName);
		txtNameAuthor.setMaximumSize(new Dimension(450,20));
		namePanel.add(txtNameAuthor);
		authorPanel.add(namePanel);
		
		JPanel fNamePanel = new JPanel();
		fNamePanel.setMaximumSize(new Dimension(1000,25));
		fNamePanel.setLayout(new BoxLayout(fNamePanel,BoxLayout.LINE_AXIS));
		JLabel fNameLabel = new JLabel("Sobrenome:");
		fNamePanel.add(fNameLabel);
		txtFNameAuthor.setMaximumSize(new Dimension(450,20));
		fNamePanel.add(txtFNameAuthor);
		authorPanel.add(fNamePanel);

		addAuthorButton.setAlignmentX(CENTER_ALIGNMENT);
		authorPanel.add(addAuthorButton);
		
		
		JPanel  publisherPanel = new JPanel();
		publisherPanel.setLayout(new BoxLayout(publisherPanel,BoxLayout.PAGE_AXIS));
		
		JPanel namePanel2 = new JPanel();
		namePanel2.setMaximumSize(new Dimension(1000,25));
		namePanel2.setLayout(new BoxLayout(namePanel2,BoxLayout.LINE_AXIS));
		JLabel labelName2 = new JLabel("Nome: ");
		namePanel2.add(labelName2);
		txtNamePublisher.setMaximumSize(new Dimension(450,20));
		namePanel2.add(txtNamePublisher);
		publisherPanel.add(namePanel2);
		
		JPanel urlPanel = new JPanel();
		urlPanel.setMaximumSize(new Dimension(1000,25));
		urlPanel.setLayout(new BoxLayout(urlPanel,BoxLayout.LINE_AXIS));
		JLabel urlLabel = new JLabel("URL:");
		urlPanel.add(urlLabel);
		txtUrlPublisher.setMaximumSize(new Dimension(450,20));
		urlPanel.add(txtUrlPublisher);
		publisherPanel.add(urlPanel);
		
		addPublisherButton.setAlignmentX(CENTER_ALIGNMENT);
		publisherPanel.add(addPublisherButton);
		
		
		JPanel bookPanel = new JPanel();
		bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.PAGE_AXIS));
		
		JPanel namePanel3 = new JPanel();
		namePanel3.setMaximumSize(new Dimension(1000,25));
		namePanel3.setLayout(new BoxLayout(namePanel3,BoxLayout.LINE_AXIS));
		JLabel labelName3 = new JLabel("Título: ");
		namePanel3.add(labelName3);
		txtNameBook.setMaximumSize(new Dimension(450,20));
		namePanel3.add(txtNameBook);
		bookPanel.add(namePanel3);
		
		JPanel isbnPanel = new JPanel();
		isbnPanel.setMaximumSize(new Dimension(1000,25));
		isbnPanel.setLayout(new BoxLayout(isbnPanel,BoxLayout.LINE_AXIS));
		JLabel labelIsbn = new JLabel("ISBN: ");
		isbnPanel.add(labelIsbn);
		txtIsbn.setMaximumSize(new Dimension(450,20));
		isbnPanel.add(txtIsbn);
		bookPanel.add(isbnPanel);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setMaximumSize(new Dimension(1000,25));
		pricePanel.setLayout(new BoxLayout(pricePanel,BoxLayout.LINE_AXIS));
		JLabel labelPrice = new JLabel("Preço: ");
		pricePanel.add(labelPrice);
		txtPrice.setMaximumSize(new Dimension(100,20));
		pricePanel.add(txtPrice);
		bookPanel.add(pricePanel);
		
		JPanel publishersPanel = new JPanel();
		publishersPanel.setMaximumSize(new Dimension(1000,155));
		publishersPanel.setLayout(new BoxLayout(publishersPanel,BoxLayout.LINE_AXIS));
		publisherTable.setModel(dtmPublisher2);
		publisherTable.removeColumn(publisherTable.getColumn("Id"));
		publisherPane.setPreferredSize(new Dimension(publishersPanel.getWidth(),155));
		publishersPanel.add(publisherPane);
		bookPanel.add(publishersPanel);
		
		JPanel authorsPanel = new JPanel();
		authorsPanel.setMaximumSize(new Dimension(1000,175));
		authorsPanel.setLayout(new BoxLayout(authorsPanel,BoxLayout.LINE_AXIS));
		authorTable.setModel(dtmAuthor2);
		authorTable.removeColumn(authorTable.getColumn("Id"));
		authorPane.setPreferredSize(new Dimension(authorsPanel.getWidth(),175));
		authorsPanel.add(authorPane);
		bookPanel.add(authorsPanel);
		
		addBookButton.setAlignmentX(CENTER_ALIGNMENT);
		bookPanel.add(addBookButton);
		
		
		JPanel cardPanelAdd = new JPanel();
		cardPanelAdd.setLayout(new CardLayout());
		cardPanelAdd.add(authorPanel, AUTHOR);
		cardPanelAdd.add(publisherPanel, PUBLISHER);
		cardPanelAdd.add(bookPanel, BOOK);
		
		cbAdd.setEditable(false);
		comboBoxPanelAdd.add(cbAdd);
		
		addPanel.add(comboBoxPanelAdd, BorderLayout.PAGE_START);
		addPanel.add(cardPanelAdd, BorderLayout.CENTER);
		
		
		editPanel.setLayout(new BorderLayout());
		
		JPanel authorPanel2 = new JPanel();
		authorPanel2.setLayout(new BoxLayout(authorPanel2, BoxLayout.PAGE_AXIS));
		
		JPanel authorsPanel2 = new JPanel();
		authorsPanel2.setMaximumSize(new Dimension(1000,300));
		authorsPanel2.setLayout(new BoxLayout(authorsPanel2,BoxLayout.LINE_AXIS));
		authorTable2.setModel(dtmAuthor3);
		authorTable2.removeColumn(authorTable2.getColumn("Id"));
		authorPane2.setPreferredSize(new Dimension(authorsPanel2.getWidth(),300));
		authorsPanel2.add(authorPane2);
		authorPanel2.add(authorsPanel2);
		
		JPanel namePanel4 = new JPanel();
		namePanel4.setMaximumSize(new Dimension(1000,25));
		namePanel4.setLayout(new BoxLayout(namePanel4,BoxLayout.LINE_AXIS));
		JLabel labelName4 = new JLabel("Nome: ");
		namePanel4.add(labelName4);
		txtNameAuthor2.setMaximumSize(new Dimension(450,20));
		namePanel4.add(txtNameAuthor2);
		authorPanel2.add(namePanel4);
		
		JPanel fNamePanel3 = new JPanel();
		fNamePanel3.setMaximumSize(new Dimension(1000,25));
		fNamePanel3.setLayout(new BoxLayout(fNamePanel3,BoxLayout.LINE_AXIS));
		JLabel fNameLabel3 = new JLabel("Sobrenome:");
		fNamePanel3.add(fNameLabel3);
		txtFNameAuthor2.setMaximumSize(new Dimension(450,20));
		fNamePanel3.add(txtFNameAuthor2);
		authorPanel2.add(fNamePanel3);
		
		editAuthorButton.setAlignmentX(CENTER_ALIGNMENT);
		authorPanel2.add(editAuthorButton);
		
		JPanel  publisherPanel2 = new JPanel();
		publisherPanel2.setLayout(new BoxLayout(publisherPanel2,BoxLayout.PAGE_AXIS));
		
		JPanel publishersPanel2 = new JPanel();
		publishersPanel2.setMaximumSize(new Dimension(1000,300));
		publishersPanel2.setLayout(new BoxLayout(publishersPanel2,BoxLayout.LINE_AXIS));
		publisherTable2.setModel(dtmPublisher3);
		publisherTable2.removeColumn(publisherTable2.getColumn("ID"));
		publisherPane2.setPreferredSize(new Dimension(publisherPane2.getWidth(),300));
		publishersPanel2.add(publisherPane2);
		publisherPanel2.add(publishersPanel2);
		
		JPanel namePanel5 = new JPanel();
		namePanel5.setMaximumSize(new Dimension(1000,25));
		namePanel5.setLayout(new BoxLayout(namePanel5,BoxLayout.LINE_AXIS));
		JLabel labelName5 = new JLabel("Nome: ");
		namePanel5.add(labelName5);
		txtNamePublisher2.setMaximumSize(new Dimension(450,20));
		namePanel5.add(txtNamePublisher2);
		publisherPanel2.add(namePanel5);
		
		JPanel urlPanel2 = new JPanel();
		urlPanel2.setMaximumSize(new Dimension(1000,25));
		urlPanel2.setLayout(new BoxLayout(urlPanel2,BoxLayout.LINE_AXIS));
		JLabel urlLabel2 = new JLabel("Website: ");
		urlPanel2.add(urlLabel2);
		txtUrlPublisher2.setMaximumSize(new Dimension(450,20));
		urlPanel2.add(txtUrlPublisher2);
		publisherPanel2.add(urlPanel2);
		
		editPublisherButton.setAlignmentX(CENTER_ALIGNMENT);
		publisherPanel2.add(editPublisherButton);
		
		
		JPanel bookPanel2 = new JPanel();
		bookPanel2.setLayout(new BoxLayout(bookPanel2, BoxLayout.PAGE_AXIS));
		
		JPanel booksPanel = new JPanel();
		booksPanel.setMaximumSize(new Dimension(1000,300));
		booksPanel.setLayout(new BoxLayout(booksPanel,BoxLayout.LINE_AXIS));
		bookTable.setModel(dtmBook2);
		bookTable.removeColumn(bookTable.getColumn("Id"));
		bookTable.removeColumn(bookTable.getColumn("aId"));
		bookPane.setPreferredSize(new Dimension(bookPane.getWidth(),300));
		booksPanel.add(bookPane);
		bookPanel2.add(booksPanel);
		
		JPanel namePanel6 = new JPanel();
		namePanel6.setMaximumSize(new Dimension(1000,25));
		namePanel6.setLayout(new BoxLayout(namePanel6,BoxLayout.LINE_AXIS));
		JLabel labelName6 = new JLabel("Título: ");
		namePanel6.add(labelName6);
		txtNameBook2.setMaximumSize(new Dimension(450,20));
		namePanel6.add(txtNameBook2);
		bookPanel2.add(namePanel6);
		
		JPanel pricePanel2 = new JPanel();
		pricePanel2.setMaximumSize(new Dimension(1000,25));
		pricePanel2.setLayout(new BoxLayout(pricePanel2,BoxLayout.LINE_AXIS));
		JLabel priceLabel2 = new JLabel("Preço: ");
		pricePanel2.add(priceLabel2);
		txtPrice2.setMaximumSize(new Dimension(100,20));
		pricePanel2.add(txtPrice2);
		bookPanel2.add(pricePanel2);
		
		editBookButton.setAlignmentX(CENTER_ALIGNMENT);
		bookPanel2.add(editBookButton);
		
		JPanel cardPanelEdit = new JPanel();
		cardPanelEdit.setLayout(new CardLayout());
		cardPanelEdit.add(authorPanel2, AUTHOR2);
		cardPanelEdit.add(publisherPanel2, PUBLISHER2);
		cardPanelEdit.add(bookPanel2, BOOK2);
		
		cbEdit.setEditable(false);
		comboBoxPanelEdit.add(cbEdit);	
		
		editPanel.add(comboBoxPanelEdit, BorderLayout.PAGE_START);
		editPanel.add(cardPanelEdit, BorderLayout.CENTER);
		
		removePanel.setLayout(new BorderLayout());
		
		JPanel authorPanel3 = new JPanel();
		authorPanel3.setLayout(new BoxLayout(authorPanel3, BoxLayout.PAGE_AXIS));
		
		JPanel authorsPanel3 = new JPanel();
		authorsPanel3.setMaximumSize(new Dimension(1000,400));
		authorsPanel3.setLayout(new BoxLayout(authorsPanel3,BoxLayout.LINE_AXIS));
		authorTable3.setModel(dtmAuthor3);
		authorTable3.removeColumn(authorTable3.getColumn("Id"));
		authorPane3.setPreferredSize(new Dimension(authorsPanel3.getWidth(),400));
		authorsPanel3.add(authorPane3);
		authorPanel3.add(authorsPanel3);
		
		removeAuthorButton.setAlignmentX(CENTER_ALIGNMENT);
		authorPanel3.add(removeAuthorButton);
		
		JPanel publisherPanel3 = new JPanel();
		publisherPanel3.setLayout(new BoxLayout(publisherPanel3,BoxLayout.PAGE_AXIS));
		
		JPanel publishersPanel3 = new JPanel();
		publishersPanel3.setMaximumSize(new Dimension(1000,400));
		publishersPanel3.setLayout(new BoxLayout(publishersPanel3,BoxLayout.LINE_AXIS));
		publisherTable3.setModel(dtmPublisher3);
		publisherTable3.removeColumn(publisherTable3.getColumn("ID"));
		publisherPane3.setPreferredSize(new Dimension(publisherPane3.getWidth(),400));
		publishersPanel3.add(publisherPane3);
		publisherPanel3.add(publishersPanel3);
		
		removePublisherButton.setAlignmentX(CENTER_ALIGNMENT);
		publisherPanel3.add(removePublisherButton);
		
		JPanel bookPanel3 = new JPanel();
		bookPanel3.setLayout(new BoxLayout(bookPanel3, BoxLayout.PAGE_AXIS));
		
		JPanel booksPanel2 = new JPanel();
		booksPanel2.setMaximumSize(new Dimension(1000,400));
		booksPanel2.setLayout(new BoxLayout(booksPanel2,BoxLayout.LINE_AXIS));
		bookTable2.setModel(dtmBook2);
		bookTable2.removeColumn(bookTable2.getColumn("Id"));
		bookTable2.removeColumn(bookTable2.getColumn("aId"));
		bookPane2.setPreferredSize(new Dimension(bookPane2.getWidth(),400));
		booksPanel2.add(bookPane2);
		bookPanel3.add(booksPanel2);
		
		removeBookButton.setAlignmentX(CENTER_ALIGNMENT);
		bookPanel3.add(removeBookButton);
		
		JPanel cardPanelRemove = new JPanel();
		cardPanelRemove.setLayout(new CardLayout());
		cardPanelRemove.add(authorPanel3, AUTHOR3);
		cardPanelRemove.add(publisherPanel3, PUBLISHER3);
		cardPanelRemove.add(bookPanel3, BOOK3);
		
		cbRemove.setEditable(false);
		comboBoxPanelRemove.add(cbRemove);	
		
		removePanel.add(comboBoxPanelRemove, BorderLayout.PAGE_START);
		removePanel.add(cardPanelRemove, BorderLayout.CENTER);
		
		setTitle("Livraria Amazônia");
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		authorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fieldBusca.setText("");
			}
		});
		bookButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fieldBusca.setText("");
			}
		});
		publisherButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fieldBusca.setText("");
			}
		});
		booksAuthorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fieldBusca.setText("");
			}
		});
		
		publisherTable2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) publisherTable2.getModel();
				int selectedRowIndex = publisherTable2.getSelectedRow();
				
				txtNamePublisher2.setText(model.getValueAt(selectedRowIndex, 1).toString());
				txtUrlPublisher2.setText(model.getValueAt(selectedRowIndex, 2).toString());
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {	}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		authorTable2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) authorTable2.getModel();
				int selectedRowIndex = authorTable2.getSelectedRow();
				
				txtNameAuthor2.setText(model.getValueAt(selectedRowIndex,1).toString());
				txtFNameAuthor2.setText(model.getValueAt(selectedRowIndex,2).toString());
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}			
		});
		
		bookTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
				int selectedRowIndex = bookTable.getSelectedRow();
				
				txtNameBook2.setText(model.getValueAt(selectedRowIndex, 1).toString());
				txtPrice2.setText(model.getValueAt(selectedRowIndex, 2).toString());
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		authorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabela.setModel(dtmAuthor);
			}
		});
		publisherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabela.setModel(dtmPublisher);
			}
		});
		bookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabela.setModel(dtmBook);
			}
		});
		booksAuthorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabela.setModel(dtmBooksAuthor);
			}
		});
		cbAdd.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout)(cardPanelAdd.getLayout());
	            cl.show(cardPanelAdd, (String)e.getItem());
			}
			
		});
		cbEdit.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout)(cardPanelEdit.getLayout());
	            cl.show(cardPanelEdit, (String)e.getItem());
			}
		});
		cbRemove.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout)(cardPanelRemove.getLayout());
	            cl.show(cardPanelRemove, (String)e.getItem());
			}
		});
		
	}
	

	@Override
	public void close() {
		
	}
	
	@Override
	public void listaAutores(List<Author> authors) {
		dtmAuthor.setRowCount(0);
		for(Author a: authors) {
			dtmAuthor.addRow(new Object[] {a.getName(), a.getFName()});
		}
		
	}

	@Override
	public void addBusca(ActionListener al) {
		buscaButton.addActionListener(al);
		
	}

	@Override
	public String getNomeBusca() {
		return fieldBusca.getText();
		}

	@Override
	public String filtroBusca() {
		String filtro = null;
		if (authorButton.isSelected()){
			filtro = "author";
		}else if(bookButton.isSelected()) {
			filtro = "book";
		}else if(publisherButton.isSelected()){
			filtro = "publisher";
		}else if(booksAuthorButton.isSelected()){
			filtro = "booksAuthor";
		}
		return filtro;
	}

	@Override
	public void listaEditoras(List<Publisher> publishers) {
		dtmPublisher.setRowCount(0);
		for(Publisher p: publishers) {
			dtmPublisher.addRow(new Object[] {p.getName(),p.getUrl()});
		};
		
	}

	@Override
	public void listaLivros(List<Book> books) {
		dtmBook.setRowCount(0);
		for(Book b: books) {
			dtmBook.addRow(new Object[] {b.getTitle(), b.getPrice()});
		}
	}

	@Override
	public void listaLivrosAutor(List<BooksAuthor> booksAuthor) {
		dtmBooksAuthor.setRowCount(0);
		for(BooksAuthor b: booksAuthor) {
			dtmBooksAuthor.addRow(new Object[] {b.getAuthorName() + " " +  b.getAuthorFname(), b.getBookName()});
		}
		
	}

	@Override
	public Author getAddAuthor() {
		String nameAuthor = txtNameAuthor.getText();
		String fNameAuthor = txtFNameAuthor.getText();
		return new Author (0, nameAuthor, fNameAuthor);
	}

	@Override
	public void addAuthor(ActionListener al) {
		addAuthorButton.addActionListener(al);
		
	}

	@Override
	public Publisher getAddPublisher() {
		String namePublisher = txtNamePublisher.getText();
		String urlPublisher = txtUrlPublisher.getText();
		return new Publisher(0, namePublisher, urlPublisher);
	}

	@Override
	public void addPublisher(ActionListener al) {
		addPublisherButton.addActionListener(al);
		
	}

	@Override
	public Book getAddBook() {
		String nameBook = txtNameBook.getText();
		String isbn = txtIsbn.getText();
		double price;
		if(txtPrice.getText().equals("")) {
		 price = -1;
		}else {
		 price	= Double.parseDouble(txtPrice.getText());
		}
		int publisherId;
		if(publisherTable.getSelectedRow() == -1) {
			publisherId = -1;
		}else {
			publisherId = (int) dtmPublisher2.getValueAt(publisherTable.getSelectedRow(), 0);
		}

		return new Book(nameBook,isbn,publisherId,price);
	}
	public int getIdAuthor() {
		int id;
		if(authorTable.getSelectedRow() == -1) {
			id = -1;
		}else {
			id = (int) dtmAuthor2.getValueAt(authorTable.getSelectedRow(), 0);
		}
		return id;
	};

	@Override
	public void addBook(ActionListener al) {
		addBookButton.addActionListener(al);
		
	}

	@Override
	public void listaAutorEditora(ActionListener al) {
		cbAdd.addActionListener(al);
		
	}

	@Override
	public void listaAutores2(List<Author> authors) {
		dtmAuthor2.setRowCount(0);
		for(Author a: authors) {
			dtmAuthor2.addRow(new Object[] {a.getId(),a.getName() + " " + a.getFName()});
		}
	}

	@Override
	public void listaEditoras2(List<Publisher> publishers) {
		dtmPublisher2.setRowCount(0);
		for(Publisher p: publishers) {
			dtmPublisher2.addRow(new Object[] {p.getId(),p.getName()});
		};
	}

	@Override
	public void listaAutores3(List<Author> authors) {
		dtmAuthor3.setRowCount(0);
		for(Author a: authors) {
			dtmAuthor3.addRow(new Object[] {a.getId(),a.getName(), a.getFName()});
		}
		
	}

	@Override
	public void listaEditoras3(List<Publisher> publishers) {
		dtmPublisher3.setRowCount(0);
		for(Publisher p: publishers) {
			dtmPublisher3.addRow(new Object[] {p.getId(),p.getName(),p.getUrl()});
		};
		
	}

	@Override
	public void listaLivros2(List<Book> books) {
		dtmBook2.setRowCount(0);
		for(Book b: books) {
			dtmBook2.addRow(new Object[] {b.getISBN(),b.getTitle(), b.getPrice(),b.getPublisherId()});
		}
	}

	@Override
	public void addEditBusca(ActionListener al) {
		cbEdit.addActionListener(al);
		
	}

	@Override
	public Author getEditAuthor() {
		String name = txtNameAuthor2.getText();
		String fName = txtFNameAuthor2.getText();
		int id = (int) dtmAuthor3.getValueAt(authorTable2.getSelectedRow(),0);
		return new Author(id,name,fName);
	}

	@Override
	public Publisher getEditPublisher() {
		String name = txtNamePublisher2.getText();
		String url = txtUrlPublisher2.getText();
		int id = (int) dtmPublisher3.getValueAt(publisherTable2.getSelectedRow(), 0);
		return new Publisher(id,name,url);
	}

	@Override
	public Book getEditBook() {
		String name = txtNameBook2.getText();
		double price;
		if(txtPrice2.getText().equals("")) {
			price = -1;
		}else {
			price = Double.parseDouble(txtPrice2.getText());
		}
		String isbn = (String) dtmBook2.getValueAt(bookTable.getSelectedRow(), 0);
		return new Book(name, isbn, 0, price);
	}


	@Override
	public void editAuthor(ActionListener al) {
		editAuthorButton.addActionListener(al);	
	}


	@Override
	public void editPublisher(ActionListener al) {
		editPublisherButton.addActionListener(al);	
	}


	@Override
	public void editBook(ActionListener al) {
		editBookButton.addActionListener(al);
		
	}


	@Override
	public void loadTables(ChangeListener cl) {
		jTab.addChangeListener(cl);
		
	}


	@Override
	public void buscaGroupButton(ActionListener al) {
		authorButton.addActionListener(al);
		publisherButton.addActionListener(al);
		bookButton.addActionListener(al);
		booksAuthorButton.addActionListener(al);
		
	}


	@Override
	public Author getRemoveAuthor() {
		String name  = dtmAuthor3.getValueAt(authorTable3.getSelectedRow(), 1).toString();
		String fName = dtmAuthor3.getValueAt(authorTable3.getSelectedRow(), 2).toString();
		int id = (int) dtmAuthor3.getValueAt(authorTable3.getSelectedRow(), 0);
		return new Author(id, name, fName);
	}


	@Override
	public void removeAuthor(ActionListener al) {
		removeAuthorButton.addActionListener(al);
		
	}


	@Override
	public void removePublisher(ActionListener al) {
		removePublisherButton.addActionListener(al);
		
	}


	@Override
	public Publisher getRemovePublisher() {
		String name = dtmPublisher3.getValueAt(publisherTable3.getSelectedRow(), 1).toString();
		String url = dtmPublisher3.getValueAt(publisherTable3.getSelectedRow(), 2).toString();
		int id = (int) dtmPublisher3.getValueAt(publisherTable3.getSelectedRow(), 0);
		return new Publisher(id,name,url);
	}


	@Override
	public Book getRemoveBook() {
		String name = dtmBook2.getValueAt(bookTable2.getSelectedRow(), 1).toString();
		String isbn = dtmBook2.getValueAt(bookTable2.getSelectedRow(), 0).toString();
		int id = (int) dtmBook2.getValueAt(bookTable2.getSelectedRow(), 3);
		double preco =(double) dtmBook2.getValueAt(bookTable2.getSelectedRow(), 2);
		return new Book(name, isbn, id, preco);
	}


	@Override
	public void removeBook(ActionListener al) {
		removeBookButton.addActionListener(al);
		
	}
	

}
