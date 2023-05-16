package Common;

import java.util.HashMap;
import java.util.Map;

/**
 * -----
 *
 * @author Elijah Sanderson
 * @author Reilly LeBlanc
 * @version 1.0
 * @since 1.0
 */

public abstract class Elements {

    public enum Category {
        ACTINIDE,
        ALKALI,
        ALKALINE_EARTH,
        LANTHANIDE,
        METALLOID,
        NOBLE_GAS,
        POST_TRANSITION,
        REACTIVE_NONMETAL,
        TRANSITION,
        UNKNOWN
    }

    public enum Phase {
        SOLID,
        LIQUID,
        GAS,
        UNKNOWN
    }

    public static enum Element {
        // (num, full name,		  mass,	   melting, boiling,	density, 	phase,  		gr,	pd,	Category,  					radio?)

        H  (1,   "Hydrogen",      1.008,   13.99,	20.271,		0.08988,	Phase.GAS,		1,	1,	Category.REACTIVE_NONMETAL,	false),
        He (2,   "Helium",        4.003,   0.95,	4.222,		0.1786,		Phase.GAS,		18,	1,	Category.NOBLE_GAS, 		false),
        Li (3,   "Lithium",       6.941,   453.65,	1603,		0.534,		Phase.SOLID,	1,	2,	Category.ALKALI,			false),
        Be (4,   "Beryllium",     9.012,   1560,	2742,		1.85,		Phase.SOLID,	2,	2,	Category.ALKALINE_EARTH,	false),
        B  (5,   "Boron",         10.811,  2349,	4200,		2.08,		Phase.SOLID,	13,	2,	Category.METALLOID,			false),
        C  (6,   "Carbon",        12.011,  0,		0,			2.267,		Phase.SOLID,	14,	2,	Category.REACTIVE_NONMETAL,	false),
        N  (7,   "Nitrogen",      14.007,  63.15,	77.355,		1.2506,		Phase.GAS,		15,	2,	Category.REACTIVE_NONMETAL,	false),
        O  (8,   "Oxygen",        15.999,  54.36,	90.188,		1.429,		Phase.GAS,		16,	2,	Category.REACTIVE_NONMETAL,	false),
        F  (9,   "Fluorine",      18.998,  53.48,	85.03,		1.696,		Phase.GAS,		17,	2,	Category.REACTIVE_NONMETAL,	false),
        Ne (10,  "Neon",          20.180,  24.56,	27.104,		0.9002,		Phase.GAS,		18,	2,	Category.NOBLE_GAS,			false),
        Na (11,  "Sodium",        22.990,  370.944,	1156.09,	0.968,		Phase.SOLID,	1,	3,	Category.ALKALI,			false),
        Mg (12,  "Magnesium",     24.305,  923,		1363,		1.738,		Phase.SOLID,	2,	3,	Category.ALKALINE_EARTH,	false),
        Al (13,  "Aluminium",      26.982,  933.47,	2743,		2.7,		Phase.SOLID,	13,	3,	Category.POST_TRANSITION,	false),
        Si (14,  "Silicon",       28.086,  1687,	3538,		2.329,		Phase.SOLID,	14,	3,	Category.METALLOID,			false),
        P  (15,  "Phosphorus",    30.974,  317.3,	553.7,		1.823,		Phase.SOLID,	15,	3,	Category.REACTIVE_NONMETAL,	false),
        S  (16,  "Sulfur",        32.065,  388.36,	717.8,		1.96,		Phase.SOLID,	16,	3,	Category.REACTIVE_NONMETAL,	false),
        Cl (17,  "Chlorine",      35.453,  171.6,	239.11,		3.2,		Phase.GAS,		17,	3,	Category.REACTIVE_NONMETAL,	false),
        Ar (18,  "Argon",         39.948,  83.81,	87.302,		1.784,		Phase.GAS,		18,	3,	Category.NOBLE_GAS,			false),
        K  (19,  "Potassium",     39.098,  336.7,	1032,		0.862,		Phase.SOLID,	1,	4,	Category.ALKALI,			false),
        Ca (20,  "Calcium",       40.078,  1115,	1757,		1.55,		Phase.SOLID,	2,	4,	Category.ALKALINE_EARTH,	false),
        Sc (21,  "Scandium",      44.956,  1814,	3109,		2.985,		Phase.SOLID,	3,	4,	Category.TRANSITION,		false),
        Ti (22,	 "Titanium",      47.867,  1941,	3560,		4.506,		Phase.SOLID,	4,	4,	Category.TRANSITION,		false),
        V  (23,	 "Vanadium",      50.942,  2183,	3680,		6.0,		Phase.SOLID,	5,	4,	Category.TRANSITION,		false),
        Cr (24,	 "Chromium",      51.996,  2180,	2944,		7.19,		Phase.SOLID,	6,	4,	Category.TRANSITION,		false),
        Mn (25,	 "Manganese",     54.938,  1519,	2334,		7.21,		Phase.SOLID,	7,	4,	Category.TRANSITION,		false),
        Fe (26,  "Iron",          55.845,  1811,	3134,		7.874,		Phase.SOLID,	8,	4,	Category.TRANSITION,		false),
        Co (27,  "Cobalt",        58.933,  1768,	3200,		8.90,		Phase.SOLID,	9,	4,	Category.TRANSITION,		false),
        Ni (28,  "Nickel",        58.693,  1728,	3003,		8.908,		Phase.SOLID,	10,	4,	Category.TRANSITION,		false),
        Cu (29,  "Copper",        63.546,  1357.77,	2835,		8.96,		Phase.SOLID,	11,	4,	Category.TRANSITION,		false),
        Zn (30,  "Zinc",          65.390,  692.68,	1180,		7.14,		Phase.SOLID,	12,	4,	Category.POST_TRANSITION,	false),
        Ga (31,  "Gallium",       69.723,  302.915,	2673,		5.91,		Phase.SOLID,	13,	4,	Category.POST_TRANSITION,	false),
        Ge (32,  "Germanium",     72.640,  1211.4,	3106,		5.323,		Phase.SOLID,	14,	4,	Category.METALLOID,			false),
        As (33,  "Arsenic",       74.922,  0,		0,			5.727,		Phase.SOLID,	15,	4,	Category.METALLOID,			false),
        Se (34,  "Selenium",      78.960,  494,		958,		4.81,		Phase.SOLID,	16,	4,	Category.REACTIVE_NONMETAL,	false),
        Br (35,  "Bromine",       79.904,  265.8,	332,		3.1028,		Phase.LIQUID,	17,	4,	Category.REACTIVE_NONMETAL,	false),
        Kr (36,  "Krypton",       83.800,  115.78,	119.93,		3.749,		Phase.GAS,		18,	4,	Category.NOBLE_GAS,			false),
        Rb (37,  "Rubidium",      85.468,  312.45,	961,		1.532,		Phase.SOLID,	1,	5,	Category.ALKALI,			false),
        Sr (38,  "Strontium",     87.620,  1050,	1650,		2.64,		Phase.SOLID,	2,	5,	Category.ALKALINE_EARTH,	false),
        Y  (39,  "Yttrium",       88.906,  1799,	3203,		4.472,		Phase.SOLID,	3,	5,	Category.TRANSITION,		false),
        Zr (40,  "Zirconium",     91.224,  2128,	4650,		6.53,		Phase.SOLID,	4,	5,	Category.TRANSITION,		false),
        Nb (41,  "Niobium",       92.906,  2750,	5017,		8.57,		Phase.SOLID,	5,	5,	Category.TRANSITION,		false),
        Mo (42,  "Molybdenum",    95.940,  2896,	4912,		10.28,		Phase.SOLID,	6,	5,	Category.TRANSITION,		false),
        Tc (43,  "Technetium",    98.000,  2430,	4538,		11,			Phase.SOLID,	7,	5,	Category.TRANSITION,		true ),
        Ru (44,  "Ruthenium",     101.070, 2607,	4423,		12.45,		Phase.SOLID,	8,	5,	Category.TRANSITION,		false),
        Rh (45,  "Rhodium",       102.906, 2237,	3968,		12.41,		Phase.SOLID,	9,	5,	Category.TRANSITION,		false),
        Pd (46,  "Palladium",     106.420, 1828.05,	3236,		12.023,		Phase.SOLID,	10,	5,	Category.TRANSITION,		false),
        Ag (47,  "Silver",        107.868, 1234.93,	2435,		10.49,		Phase.SOLID,	11,	5,	Category.TRANSITION,		false),
        Cd (48,  "Cadmium",       112.411, 594.22,	1040,		8.65,		Phase.SOLID,	12,	5,	Category.POST_TRANSITION,	false),
        In (49,  "Indium",        114.818, 429.749,	2345,		7.31,		Phase.SOLID,	13,	5,	Category.POST_TRANSITION,	false),
        Sn (50,  "Tin",           118.710, 505.08,	2875,		7.265,		Phase.SOLID,	14,	5,	Category.POST_TRANSITION,	false),
        Sb (51,  "Antimony",      121.760, 903.78,	1908,		6.697,		Phase.SOLID,	15,	5,	Category.METALLOID,			false),
        Te (52,  "Tellurium",     127.600, 722.66,	1261,		6.24,		Phase.SOLID,	16,	5,	Category.METALLOID,			false),
        I  (53,  "Iodine",        126.905, 386.85,	457.4,		4.933,		Phase.SOLID,	17,	5,	Category.REACTIVE_NONMETAL,	false),
        Xe (54,  "Xenon",         131.293, 161.4,	165.051,	5.894,		Phase.GAS,		18,	5,	Category.NOBLE_GAS,			false),
        Cs (55,  "Caesium",       132.906, 301.7,	944,		1.93,		Phase.SOLID,	1,	6,	Category.ALKALI,			false),
        Ba (56,  "Barium",        137.327, 1000,	2118,		3.51,		Phase.SOLID,	2,	6,	Category.ALKALINE_EARTH,	false),
        La (57,  "Lanthanum",     138.906, 1193,	3737,		6.162,		Phase.SOLID,	3,	6,	Category.LANTHANIDE,		false),
        Ce (58,  "Cerium",        140.116, 1068,	3716,		6.77,		Phase.SOLID,	4,	8,	Category.LANTHANIDE,		false),
        Pr (59,  "Praseodymium",  140.908, 1208,	3403,		6.77,		Phase.SOLID,	5,	8,	Category.LANTHANIDE,		false),
        Nd (60,  "Neodymium",     144.240, 1297,	3347,		7.01,		Phase.SOLID,	6,	8,	Category.LANTHANIDE,		false),
        Pm (61,  "Promethium",    145.000, 1315,	3237,		7.26,		Phase.SOLID,	7,	8,	Category.LANTHANIDE,		true ),
        Sm (62,  "Samarium",      150.360, 1345,	2173,		7.52,		Phase.SOLID,	8,	8,	Category.LANTHANIDE,		false),
        Eu (63,  "Europium",      151.964, 1099,	1802,		5.264,		Phase.SOLID,	9,	8,	Category.LANTHANIDE,		false),
        Gd (64,  "Gadolinium",    157.250, 1585,	3273,		7.90,		Phase.SOLID,	10,	8,	Category.LANTHANIDE,		false),
        Tb (65,  "Terbium",       158.925, 1629,	3396,		8.23,		Phase.SOLID,	11,	8,	Category.LANTHANIDE,		false),
        Dy (66,  "Dysprosium",    162.500, 1680,	2840,		8.54,		Phase.SOLID,	12,	8,	Category.LANTHANIDE,		false),
        Ho (67,  "Holmium",       164.930, 1734,	2873,		8.79,		Phase.SOLID,	13,	8,	Category.LANTHANIDE,		false),
        Er (68,  "Erbium",        167.259, 1802,	3141,		9.066,		Phase.SOLID,	14,	8,	Category.LANTHANIDE,		false),
        Tm (69,  "Thulium",       168.934, 1818,	2223,		9.32,		Phase.SOLID,	15,	8,	Category.LANTHANIDE,		false),
        Yb (70,  "Ytterbium",     173.040, 1097,	1469,		6.9,		Phase.SOLID,	16,	8,	Category.LANTHANIDE,		false),
        Lu (71,  "Lutetium",      174.967, 1925,	3675,		9.841,		Phase.SOLID,	17,	8,	Category.LANTHANIDE,		false),
        Hf (72,  "Hafnium",       178.490, 2506,	4876,		13.31,		Phase.SOLID,	4,	6,	Category.TRANSITION,		false),
        Ta (73,  "Tantalum",      180.948, 3290,	5731,		16.69,		Phase.SOLID,	5,	6,	Category.TRANSITION,		false),
        W  (74,  "Tungsten",      183.840, 3695,	6203,		19.3,		Phase.SOLID,	6,	6,	Category.TRANSITION,		false),
        Re (75,  "Rhenium",       186.207, 3459,	5903,		21.02,		Phase.SOLID,	7,	6,	Category.TRANSITION,		false),
        Os (76,	 "Osmium",        190.230, 3306,	5285,		22.59,		Phase.SOLID,	8,	6,	Category.TRANSITION,		false),
        Ir (77,	 "Iridium",       192.217, 2719,	4403,		22.56,		Phase.SOLID,	9,	6,	Category.TRANSITION,		false),
        Pt (78,  "Platinum",      195.078, 2041.4,	4098,		21.45,		Phase.SOLID,	10,	6,	Category.TRANSITION,		false),
        Au (79,  "Gold",          196.967, 1337.33,	3243,		19.3,		Phase.SOLID,	11,	6,	Category.TRANSITION,		false),
        Hg (80,  "Mercury",       200.590, 234.321,	629.88,		13.534,		Phase.LIQUID,	12,	6,	Category.POST_TRANSITION,	false),
        Tl (81,  "Thallium",      204.383, 577,		1746,		11.85,		Phase.SOLID,	13,	6,	Category.POST_TRANSITION,	false),
        Pb (82,  "Lead",          207.200, 600.61,	2022,		11.34,		Phase.SOLID,	14,	6,	Category.POST_TRANSITION,	false),
        Bi (83,  "Bismuth",       208.980, 544.7,	1837,		9.78,		Phase.SOLID,	15,	6,	Category.POST_TRANSITION,	false),
        Po (84,  "Polonium",      209.000, 527,		1235,		9.196,		Phase.SOLID,	16,	6,	Category.POST_TRANSITION,	true),
        At (85,  "Astatine",      210.000, 575,		610,		0,			Phase.SOLID,	17,	6,	Category.METALLOID,			true),
        Rn (86,  "Radon",         222.000, 202,		211.5,		9.73,		Phase.GAS,		18,	6,	Category.NOBLE_GAS,			true),
        Fr (87,  "Francium",      223.000, 0,		0,			0,			Phase.SOLID,	1,	7,	Category.ALKALI,			true),
        Ra (88,  "Radium",        226.000, 973,		2010,		5.5,		Phase.SOLID,	2,	7,	Category.ALKALINE_EARTH,	true),
        Ac (89,  "Actinium",      227.000, 1500,	3500,		10,			Phase.SOLID,	3,	7,	Category.ACTINIDE,			true),
        Th (90,  "Thorium",       232.038, 2023,	5061,		11.7,		Phase.SOLID,	4,	9,	Category.ACTINIDE,			true),
        Pa (91,  "Protactinium",  231.036, 1841,	4300,		15.37,		Phase.SOLID,	5,	9,	Category.ACTINIDE,			true),
        U  (92,  "Uranium",       238.029, 1405.3,	4404,		19.1,		Phase.SOLID,	6,	9,	Category.ACTINIDE,			true),
        Np (93,  "Neptunium",     237.000, 912,		4447,		20.45,		Phase.SOLID,	7,	9,	Category.ACTINIDE,			true),
        Pu (94,  "Plutonium",     244.000, 912.5,	3505,		19.816,		Phase.SOLID,	8,	9,	Category.ACTINIDE,			true),
        Am (95,  "Americium",     243.000, 1449,	2880,		12,			Phase.SOLID,	9,	9,	Category.ACTINIDE,			true),
        Cm (96,  "Curium",        247.000, 1613,	3383,		13.51,		Phase.SOLID,	10,	9,	Category.ACTINIDE,			true),
        Bk (97,  "Berkelium",     247.000, 1259,	2900,		14.78,		Phase.SOLID,	11,	9,	Category.ACTINIDE,			true),
        Cf (98,  "Californium",   251.000, 1173,	1743,		15.1,		Phase.SOLID,	12,	9,	Category.ACTINIDE,			true),
        Es (99,  "Einsteinium",   252.000, 1133,	1269,		8.84,		Phase.SOLID,	13,	9,	Category.ACTINIDE,			true),
        Fm (100, "Fermium",       257.000, 1800,	0,			0,			Phase.UNKNOWN,	14,	9,	Category.ACTINIDE,			true),
        Md (101, "Mendelevium",   258.000, 1100,	0,			0,			Phase.UNKNOWN,	15,	9,	Category.ACTINIDE,			true),
        No (102, "Nobelium",      259.000, 1100,	0,			0,			Phase.UNKNOWN,	16,	9,	Category.ACTINIDE,			true),
        Lr (103, "Lawrencium",    262.000, 1900,	0,			0,			Phase.UNKNOWN,	17,	9,	Category.ACTINIDE,			true),
        Rf (104, "Rutherfordium", 261.000, 0,		0,			0,			Phase.UNKNOWN,	4,	7,	Category.TRANSITION,		true),
        Db (105, "Dubnium",       262.000, 0,		0,			0,			Phase.UNKNOWN,	5,	7,	Category.TRANSITION,		true),
        Sg (106, "Seaborgium",    266.000, 0,		0,			0,			Phase.UNKNOWN,	6,	7,	Category.TRANSITION,		true),
        Bh (107, "Bohrium",       264.000, 0,		0,			0,			Phase.UNKNOWN,	7,	7,	Category.TRANSITION,		true),
        Hs (108, "Hassium",       277.000, 0,		0,			0,			Phase.UNKNOWN,	8,	7,	Category.TRANSITION,		true),
        Mt (109, "Meitnerium",    268.000, 0,		0,			0,			Phase.UNKNOWN,	9,	7,	Category.UNKNOWN,			true),
        Ds (110, "Darmstadtium",  281.000, 0,		0,			0,			Phase.UNKNOWN,	10,	7,	Category.UNKNOWN,			true),
        Rg (111, "Roentgenium",   281.000, 0,		0,			0,			Phase.UNKNOWN,	11,	7,	Category.UNKNOWN,			true),
        Cn (112, "Copernicium",   285.000, 0,		0,			0,			Phase.UNKNOWN,	12,	7,	Category.POST_TRANSITION,	true),
        Nh (113, "Nihonium",      286.000, 0,		0,			0,			Phase.UNKNOWN,	13,	7,	Category.UNKNOWN,			true),
        Fl (114, "Flerovium",     289.000, 0,		0,			0,			Phase.UNKNOWN,	14,	7,	Category.UNKNOWN,			true),
        Mc (115, "Moscovium",     289.000, 0,		0,			0,			Phase.UNKNOWN,	15,	7,	Category.UNKNOWN,			true),
        Lv (116, "Livermorium",   293.000, 0,		0,			0,			Phase.UNKNOWN,	16,	7,	Category.UNKNOWN,			true),
        Ts (117, "Tennessine",    293.000, 0,		0,			0,			Phase.UNKNOWN,	17,	7,	Category.UNKNOWN,			true),
        Og (118, "Oganesson",     294.000, 0,		0,			0,			Phase.UNKNOWN,	18,	7,	Category.UNKNOWN,			true)
        ;

        private static class Holder {
            static Map<Integer, Element> map = new HashMap<>();
        }

        private final int atomicNumber;
        private final String fullName;
        private final double atomicMass;
        private final double meltingPoint;
        private final double boilingPoint;
        private final double density;
        private final Phase phase;
        private int group;
        private int period;
        private final Category category;
        private final boolean radioactive;


        private Element(int atomicNumber, String fullName, double atomicMass, double meltingPoint, double boilingPoint, double density, Phase phase, int group, int period, Category category, boolean radioactive) {
            this.atomicNumber = atomicNumber;
            this.fullName = fullName;
            this.atomicMass = atomicMass;
            this.meltingPoint = meltingPoint;
            this.boilingPoint = boilingPoint;
            this.density = density;
            this.phase = phase;
            this.group = group;
            this.period = period;
            this.category = category;
            this.radioactive = radioactive;
            Holder.map.put(atomicNumber, this);
        }

        public static Element forAtomicNumber(int atomicNumber) {
            return Holder.map.get(atomicNumber);
        }

        public int getAtomicNumber() {
            return atomicNumber;
        }

        public String getFullName() {
            return fullName;
        }

        public double getAtomicMass() {
            return atomicMass;
        }

        public double getMeltingPoint() {
            return meltingPoint;
        }

        public double getBoilingPoint() {
            return boilingPoint;
        }

        public double getDensity() {
            return density;
        }

        public Phase getPhase() {
            return phase;
        }

        public int getGroup() {
            return group;
        }

        public int getPeriod() {
            return period;
        }

        public Category getCategory() {
            return category;
        }

        public boolean isRadioactive() {
            return radioactive;
        }

    }

}