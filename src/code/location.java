import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class location extends JFrame {
    
    static String location;
    static String destination;
    
    public location() throws IOException {
        super("location");
        String[] optionsToChoose = { "Abilene", "Addison", "Alamo", "Alamo Heights", "Aldine", "Aledo", "Alice",
                "Allen", "Alpine", "Alton", "Alvarado", "Alvin", "Amarillo", "Andrews", "Angleton", "Anna", "Anthony",
                "Aransas Pass", "Argyle", "Arlington", "Atascocita", "Athens", "Atlanta", "Aubrey", "Austin", "Azle",
                "Bacliff", "Balch Springs", "Barrett", "Bastrop", "Bay City", "Baytown", "Beaumont", "Bedford",
                "Bee Cave", "Beeville", "Bellaire", "Bellmead", "Bellville", "Belton", "Benbrook", "Big Spring",
                "Boerne", "Bonham", "Borger", "Bowie", "Brady", "Breckenridge", "Brenham", "Briar", "Bridge City",
                "Bridgeport", "Brookshire", "Brownfield", "Brownsville", "Brownwood", "Brushy Creek", "Bryan", "Buda",
                "Bullard", "Bulverde", "Bunker Hill Village", "Burkburnett", "Burleson", "Burnet", "Caldwell",
                "Cameron", "Cameron Park", "Camp Swift", "Canton", "Canutillo", "Canyon", "Canyon Lake", "Carrizo Springs",
                "Carrollton", "Carthage", "Castle Hills", "Cedar Hill", "Cedar Park", "Celina", "Center", "Central Gardens",
                "Channelview", "Childress", "Chula Vista", "Cibolo", "Cinco Ranch", "Cisco", "Cleburne", "Cleveland", "Cloverleaf",
                "Clute", "Clyde", "Cockrell Hill", "Coleman", "College Station", "Colleyville", "Colorado City", "Columbus", "Comanche",
                "Commerce","Conroe", "Converse",
                "Coppell",
                "Copperas Cove",
                "Corinth",
                "Corpus Christi",
                "Corsicana",
                "Cotulla",
                "Crandall",
                "Crane",
                "Crockett",
                "Crowley",
                "Crystal City",
                "Cuero",
                "Dalhart",
                "Dallas",
                "Dayton",
                "Decatur",
                "Deer Park",
                "Del Rio",
                "Denison",
                "Denton",
                "Denver City",
                "DeSoto",
                "Devine",
                "Diboll",
                "Dickinson",
                "Dilley",
                "Dimmitt",
                "Doffing",
                "Donna",
                "Dripping Springs",
                "Dumas",
                "Duncanville",
                "Eagle Lake",
                "Eagle Pass",
                "Eastland",
                "Edinburg",
                "Edna",
                "Eidson Road",
                "El Campo",
                "El Paso",
                "Elgin",
                "Elsa",
                "Ennis",
                "Euless",
                "Everman",
                "Fabens",
                "Fair Oaks Ranch",
                "Fairview",
                "Falfurrias",
                "Farmers Branch",
                "Farmersville",
                "Fate",
                "Floresville",
                "Flower Mound",
                "Forest Hill",
                "Forney",
                "Fort Bliss",
                "Fort Hood",
                "Fort Stockton",
                "Fort Worth",
                "Four Corners",
                "Fredericksburg",
                "Freeport",
                "Fresno",
                "Friendswood",
                "Frisco",
                "Fulshear",
                "Gainesville",
                "Galena Park",
                "Galveston",
                "Garden Ridge",
                "Garland",
                "Gatesville",
                "Georgetown",
                "Giddings",
                "Gilmer",
                "Gladewater",
                "Glenn Heights",
                "Gonzales",
                "Graham",
                "Granbury",
                "Grand Prairie",
                "Granite Shoals",
                "Grapevine",
                "Greenville",
                "Groesbeck",
                "Groves",
                "Gun Barrel City",
                "Hallsville",
                "Haltom City",
                "Harker Heights",
                "Harlingen",
                "Hearne",
                "Heath",
                "Hebbronville",
                "Helotes",
                "Hempstead",
                "Henderson",
                "Hereford",
                "Hewitt",
                "Hickory Creek",
                "Hidalgo",
                "Highland Park",
                "Highland Village",
                "Highlands",
                "Hillsboro",
                "Hitchcock",
                "Homestead Meadows North",
                "Homestead Meadows South",
                "Hondo",
                "Horizon City",
                "Hornsby Bend",
                "Horseshoe Bay",
                "Houston",
                "Hudson",
                "Humble",
                "Hunters Creek Village",
                "Huntsville",
                "Hurst",
                "Hutchins",
                "Hutto",
                "Ingleside",
                "Iowa Colony",
                "Iowa Park",
                "Irving",
                "Jacinto City",
                "Jacksboro",
                "Jacksonville",
                "Jasper",
                "Jersey Village",
                "Joshua",
                "Jourdanton",
                "Justin",
                "Katy",
                "Kaufman",
                "Keene",
                "Keller",
                "Kennedale",
                "Kermit",
                "Kerrville",
                "Kilgore",
                "Killeen",
                "Kingsland",
                "Kingsville",
                "Kirby",
                "Krum",
                "Kyle",
                "La Feria",
                "La Grange",
                "La Homa",
                "La Joya",
                "La Marque",
                "La Paloma",
                "La Porte",
                "Lackland AFB",
                "Lacy-Lakeview",
                "Lago Vista",
                "Lake Dallas",
                "Lake Jackson",
                "Lake Worth",
                "Lakehills",
                "Lakeway",
                "Lamesa",
                "Lampasas",
                "Lancaster",
                "Lantana",
                "Laredo",
                "Laureles",
                "Lavon",
                "League City",
                "Leander",
                "Leon Valley",
                "Levelland",
                "Lewisville",
                "Liberty",
                "Liberty Hill",
                "Lindale",
                "Little Elm",
                "Littlefield",
                "Live Oak",
                "Livingston",
                "Lockhart",
                "Longview",
                "Los Fresnos",
                "Lubbock",
                "Lucas",
                "Lufkin",
                "Luling",
                "Lumberton",
                "Mabank",
                "Madisonville",
                "Manor",
                "Mansfield",
                "Manvel",
                "Marble Falls",
                "Marlin",
                "Marshall",
                "Mathis",
                "McAllen",
                "McGregor",
                "McKinney",
                "McLendon-Chisholm",
                "Meadows Place",
                "Medina",
                "Melissa",
                "Mercedes",
                "Mesquite",
                "Mexia",
                "Midland",
                "Midlothian",
                "Midway North",
                "Mila Doce",
                "Mineola",
                "Mineral Wells",
                "Mission",
                "Mission Bend",
                "Missouri City",
                "Monahans",
                "Mont Belvieu",
                "Morgan's Point Resort",
                "Mount Pleasant",
                "Muleshoe",
                "Murillo",
                "Murphy",
                "Nacogdoches",
                "Nash",
                "Nassau Bay",
                "Navasota",
                "Nederland",
                "New Boston",
                "New Braunfels",
                "Nolanville",
                "North Richland Hills",
                "Northlake",
                "Oak Point",
                "Odessa",
                "Olivarez",
                "Orange",
                "Ovilla",
                "Palacios",
                "Palestine",
                "Palmview",
                "Palmview South",
                "Paloma Creek South",
                "Pampa",
                "Paris",
                "Parker",
                "Pasadena",
                "Pearland",
                "Pearsall",
                "Pecan Acres",
                "Pecan Grove",
                "Pecan Plantation",
                "Pecos",
                "Penitas",
                "Perezville",
                "Perryton",
                "Pflugerville",
                "Pharr",
                "Pilot Point",
                "Pinehurst",
                "Pittsburg",
                "Plainview",
                "Plano",
                "Pleasanton",
                "Port Aransas",
                "Port Arthur",
                "Port Isabel",
                "Port Lavaca",
                "Port Neches",
                "Portland",
                "Post",
                "Prairie View",
                "Primera",
                "Princeton",
                "Progreso",
                "Prosper",
                "Providence Village",
                "Raymondville",
                "Red Oak",
                "Redwood",
                "Rendon",
                "Richardson",
                "Richland Hills",
                "Richmond",
                "Richwood",
                "Rio Bravo",
                "Rio Grande City",
                "River Oaks",
                "Roanoke",
                "Robinson",
                "Robstown",
                "Rockdale",
                "Rockport",
                "Rockwall",
                "Roma",
                "Rosenberg",
                "Round Rock",
                "Rowlett",
                "Royse City",
                "Rusk",
                "Sachse",
                "Saginaw",
                "San Angelo",
                "San Antonio",
                "San Benito",
                "San Carlos",
                "San Diego",
                "San Elizario",
                "San Juan",
                "San Leon",
                "San Marcos",
                "Sandy Oaks",
                "Sanger",
                "Sansom Park",
                "Santa Fe",
                "Savannah",
                "Scenic Oaks",
                "Schertz",
                "Seabrook",
                "Seagoville",
                "Sealy",
                "Seguin",
                "Selma",
                "Seminole",
                "Shady Hollow",
                "Shavano Park",
                "Sherman",
                "Sienna Plantation",
                "Silsbee",
                "Sinton",
                "Slaton",
                "Smithville",
                "Snyder",
                "Socorro",
                "South Houston",
                "Southlake",
                "Sparks",
                "Spring",
                "Spring Valley Village",
                "Stafford",
                "Stephenville",
                "Sugar Land",
                "Sullivan City",
                "Sulphur Springs",
                "Sunnyvale",
                "Sweetwater",
                "Taylor",
                "Temple",
                "Terrell",
                "Terrell Hills",
                "Texarkana",
                "Texas City",
                "The Colony",
                "The Woodlands",
                "Timberwood Park",
                "Tomball",
                "Travis Ranch",
                "Trophy Club",
                "Tulia",
                "Tyler",
                "Universal City",
                "University Park",
                "Uvalde",
                "Van Alstyne",
                "Venus",
                "Vernon",
                "Victoria",
                "Vidor",
                "Waco",
                "Wake Village",
                "Watauga",
                "Waxahachie",
                "Weatherford",
                "Webster",
                "Wells Branch",
                "Weslaco",
                "West Livingston",
                "West Odessa",
                "West University Place",
                "Weston Lakes",
                "Wharton",
                "White Oak",
                "White Settlement",
                "Whitehouse",
                "Whitesboro",
                "Wichita Falls",
                "Willis",
                "Willow Park",
                "Wills Point",
                "Wilmer",
                "Windcrest",
                "Wolfforth",
                "Woodway",
                "Wylie",
                "Yoakum",
                "Zapata"
        };
        setSize(1120, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel question = new JLabel("Enter your current location");
        question.setBounds(370, 80, 500, 34);
        question.setFont(new java.awt.Font("Arial", 1, 30));
        question.setForeground(Color.black);
        add(question);

        JTextField currloc = new JTextField();
        currloc.setBounds(290, 140, 240, 34);
        currloc.setFont(new Font("Helvetica", Font.PLAIN, 20));
        currloc.setOpaque(false);
        currloc.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        currloc.setForeground(Color.darkGray);

        add(currloc);

        JComboBox<String> combo = new JComboBox<String>(optionsToChoose);
        combo.setBounds(590, 140, 240, 34);
        combo.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(combo);

        JLabel destination = new JLabel("Enter your destination");
        destination.setBounds(410, 250, 500, 34);
        destination.setFont(new java.awt.Font("Arial", 1, 30));
        destination.setForeground(Color.white);
        add(destination);

        JTextField dtext = new JTextField();
        dtext.setBounds(290, 310, 240, 34);
        dtext.setFont(new Font("Helvetica", Font.PLAIN, 20));
        dtext.setBackground(Color.white);
        dtext.setBorder(BorderFactory.createLineBorder(Color.black));
        add(dtext);

        JComboBox<String> combo2 = new JComboBox<String>(optionsToChoose);
        combo2.setBounds(590, 310, 240, 34);
        combo2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(combo2);

        JButton search = new JButton("Search for rides");
        search.setFont(new java.awt.Font("Arial", 1, 24));
        search.setBounds(430, 450, 250, 40);
        search.setBackground(Color.decode("#03A99E"));
        search.setForeground(Color.white);
        add(search);

        // actionlistener for button pressed
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // get text from combobox
                String location = combo.getSelectedItem().toString();
                String destination = combo2.getSelectedItem().toString();
                fileFunctions.writeFile("location.txt", location, destination, pageOne.username);
                try {
                    loading.loadingSFR();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        getRootPane().setDefaultButton(search);

        // addKeyListener(new java.awt.event.KeyAdapter() {
        //     public void keyPressed(java.awt.event.KeyEvent evt) {
        //         if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        //             // get text from combobox
        //             String location = combo.getSelectedItem().toString();
        //             String destination = combo2.getSelectedItem().toString();
        //             fileFunctions.writeFileforlogin("test.txt", location, destination);
        //             try {
        //                 loading.loadingscreen();
        //             } catch (IOException e) {
        //                 // TODO Auto-generated catch block
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // });

        JLabel bgPic = new JLabel(new ImageIcon("otherFiles/popo2.png"));
        bgPic.setBounds(0, 0, 1106, 728);
        add(bgPic);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) throws Exception {
        new location();
    }
}