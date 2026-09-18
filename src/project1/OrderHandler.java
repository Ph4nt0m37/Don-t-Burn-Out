package project1;

public class OrderHandler
{
    private Order currentOrder;
    private String subject;
    private String currentQuestion;
    private String currentAnswer;
    private String[] mathQuestionBank = 
    {
        // easy — 0 to 32
        "What is 5 + 7?",
        "What is 12 - 5?",
        "What is 6 * 4?",
        "What is 20 / 5?",
        "What is 10 + 15?",
        "What is 30 - 12?",
        "What is 7 * 3?",
        "What is 36 / 6?",
        "What is 9 + 8?",
        "What is 25 - 10?",
        "What is 5 * 5?",
        "What is 48 / 8?",
        "What is 14 + 9?",
        "What is 40 - 17?",
        "What is 8 * 4?",
        "What is 63 / 7?",
        "What is 11 + 12?",
        "What is 50 - 25?",
        "What is 9 * 6?",
        "What is 72 / 9?",
        "What is 15 + 16?",
        "What is 60 - 24?",
        "What is 7 * 8?",
        "What is 81 / 9?",
        "What is 18 + 17?",
        "What is 100 - 45?",
        "What is 12 * 5?",
        "What is 96 / 12?",
        "What is 22 + 19?",
        "What is 75 - 28?",
        "What is 11 * 7?",
        "What is 144 / 12?",
        "What is 25% of 100?",

        // medium — 33 to 65
        "What is 15% of 200?",
        "Solve: x + 7 = 15.",
        "Solve: x - 9 = 12.",
        "Solve: 3x = 21.",
        "Solve: x / 4 = 6.",
        "What is 3/4 + 1/4?",
        "What is 5/6 - 1/6?",
        "What is 2/3 * 3/4?",
        "What is 3/5 divided by 1/5?",
        "What is the perimeter of a rectangle with length 8 and width 5?",
        "What is the area of a rectangle with length 9 and width 4?",
        "What is the area of a triangle with base 10 and height 6?",
        "What is the average of 10, 20, and 30?",
        "What is the next number: 2, 4, 8, 16, ___?",
        "What is 2^5?",
        "What is the square root of 144?",
        "Simplify: 3(x + 4).",
        "Solve: 2x + 5 = 15.",
        "Solve: 4x - 3 = 17.",
        "What is the slope between (1,2) and (3,6)?",
        "What is the y-intercept of y = 2x + 5?",
        "Convert 0.75 to a fraction.",
        "Convert 3/5 to a decimal.",
        "What is 30% of 250?",
        "A shirt costs $40 and is 25% off. What is the sale price?",
        "What is the probability of rolling a 6 on a standard die?",
        "What is the probability of getting heads when flipping a fair coin?",
        "Simplify: 5x + 3x.",
        "Simplify: 7x - 2x + 4.",
        "Solve: 5x + 10 = 35.",
        "What is the circumference of a circle with radius 5?",
        "What is the area of a circle with radius 3?",
        "What is the volume of a rectangular prism measuring 2 × 3 × 4?",

        // hard — 66 to 99
        "Solve: 3x + 7 = 25.",
        "Solve: 5x - 8 = 32.",
        "Solve: 2(x + 3) = 18.",
        "Solve: 4(x - 2) = 28.",
        "Solve: 3x + 5 = 2x + 14.",
        "Solve: 7x - 4 = 3x + 20.",
        "Factor: x^2 + 5x + 6.",
        "Factor: x^2 - 9.",
        "Expand: (x + 3)(x + 4).",
        "Expand: (x - 2)(x + 5).",
        "Solve: x^2 = 49.",
        "Solve: x^2 - 9 = 0.",
        "What is the slope of a line perpendicular to y = 2x + 1?",
        "What is the distance between (0,0) and (3,4)?",
        "What is the midpoint of (2,4) and (6,8)?",
        "Simplify: (2x^2)(3x^3).",
        "Simplify: x^5 / x^2.",
        "Simplify: (x^3)^2.",
        "What is log10(1000)?",
        "What is 2^3 * 2^4?",
        "Solve: 2^x = 32.",
        "Solve: x/3 + 4 = 10.",
        "A right triangle has legs 6 and 8. What is its hypotenuse?",
        "What is the area of a trapezoid with bases 8 and 12 and height 5?",
        "What is the volume of a cylinder with radius 3 and height 4?",
        "What is the derivative of x^2?",
        "What is the derivative of 3x^2 + 2x?",
        "What is the integral of 2x?",
        "Evaluate: lim(x->2) (x + 3).",
        "Solve the system: x + y = 10 and x - y = 2.",
        "What is the discriminant of x^2 + 4x + 4?",
        "Solve: x^2 - 5x + 6 = 0.",
        "What is the probability of drawing an ace from a standard 52-card deck?",
        "If f(x) = 2x + 3, what is f(5)?"
    };
    
    private String[] mathAnswerBank = 
    {
        // easy — 0 to 32
        "12",
        "7",
        "24",
        "4",
        "25",
        "18",
        "21",
        "6",
        "17",
        "15",
        "25",
        "6",
        "23",
        "23",
        "32",
        "9",
        "23",
        "25",
        "54",
        "8",
        "31",
        "36",
        "56",
        "9",
        "35",
        "55",
        "60",
        "8",
        "41",
        "47",
        "77",
        "12",
        "25",

        // medium — 33 to 65
        "30",
        "8",
        "21",
        "7",
        "24",
        "1",
        "2/3",
        "1/2",
        "3",
        "26",
        "36",
        "30",
        "20",
        "32",
        "32",
        "12",
        "3x + 12",
        "5",
        "5",
        "2",
        "5",
        "3/4",
        "0.6",
        "75",
        "$30",
        "1/6",
        "1/2",
        "8x",
        "5x + 4",
        "5",
        "10π",
        "9π",
        "24",

        // hard — 66 to 99
        "6",
        "8",
        "6",
        "9",
        "9",
        "6",
        "(x + 2)(x + 3)",
        "(x - 3)(x + 3)",
        "x^2 + 7x + 12",
        "x^2 + 3x - 10",
        "7 or -7",
        "3 or -3",
        "-1/2",
        "5",
        "(4,6)",
        "6x^5",
        "x^3",
        "x^6",
        "3",
        "128",
        "5",
        "18",
        "10",
        "50",
        "36π",
        "2x",
        "6x + 2",
        "x^2 + C",
        "5",
        "6",
        "0",
        "0",
        "1/13",
        "13"
    };

    
    private String[] scienceQuestionBank = 
    {
        // easy — 0 to 32
        "What planet is closest to the Sun?",
        "What planet is known as the Red Planet?",
        "What is the largest planet in our solar system?",
        "What gas do humans need to breathe?",
        "What gas do plants absorb during photosynthesis?",
        "What is H2O commonly called?",
        "What is the center of an atom called?",
        "What force pulls objects toward Earth?",
        "What organ pumps blood through the body?",
        "What organ is primarily responsible for breathing?",
        "What is the basic unit of life?",
        "What is Earth's natural satellite?",
        "How many bones are in the adult human body?",
        "What is the boiling point of water at sea level in Celsius?",
        "What is the freezing point of water in Celsius?",
        "What star is at the center of our solar system?",
        "What process do plants use to make food?",
        "What part of a plant absorbs water from soil?",
        "What is the largest organ of the human body?",
        "What type of energy comes from the Sun?",
        "What are animals that eat only plants called?",
        "What are animals that eat only meat called?",
        "What is the chemical symbol for oxygen?",
        "What is the chemical symbol for gold?",
        "How many planets are in our solar system?",
        "What layer of Earth do we live on?",
        "What is the change from liquid to gas called?",
        "What is the change from gas to liquid called?",
        "What is the change from solid to liquid called?",
        "What is the change from liquid to solid called?",
        "What instrument measures temperature?",
        "What instrument measures air pressure?",
        "What is Earth's atmosphere mostly made of?",

        // medium — 33 to 65
        "What is the chemical symbol for sodium?",
        "What is the chemical symbol for potassium?",
        "What is the pH of a neutral solution?",
        "What particle has a negative charge?",
        "What particle has a positive charge?",
        "What particle has no electrical charge?",
        "What is the powerhouse of the cell?",
        "What organelle contains DNA in most eukaryotic cells?",
        "What process produces two identical daughter cells?",
        "What molecule carries genetic information?",
        "What is the function of red blood cells?",
        "What is the function of white blood cells?",
        "What is Newton's first law about?",
        "What is Newton's second law?",
        "What is Newton's third law?",
        "What is the SI unit of force?",
        "What is the SI unit of energy?",
        "What is the SI unit of power?",
        "What is velocity?",
        "What is acceleration?",
        "What type of bond involves sharing electrons?",
        "What type of bond involves transferring electrons?",
        "What is the atomic number of carbon?",
        "What is the atomic number of oxygen?",
        "What is the chemical formula for carbon dioxide?",
        "What is the chemical formula for table salt?",
        "What is an ecosystem?",
        "What is a food chain?",
        "What is the role of decomposers?",
        "What is biodiversity?",
        "What causes Earth's seasons?",
        "What causes ocean tides?",
        "What is the greenhouse effect?",

        // hard — 66 to 99
        "What is the difference between mass and weight?",
        "What is the law of conservation of energy?",
        "What is kinetic energy?",
        "What is potential energy?",
        "What is the equation for kinetic energy?",
        "What is the equation for gravitational potential energy?",
        "What is Ohm's law?",
        "What is electrical resistance measured in?",
        "What is the difference between a series and parallel circuit?",
        "What is electromagnetic induction?",
        "What is the first law of thermodynamics?",
        "What is entropy?",
        "What is an exothermic reaction?",
        "What is an endothermic reaction?",
        "What is activation energy?",
        "What is a catalyst?",
        "What is molarity?",
        "What is Avogadro's number?",
        "What is an isotope?",
        "What is half-life?",
        "What is natural selection?",
        "What is genetic drift?",
        "What is gene flow?",
        "What is a mutation?",
        "What is DNA replication?",
        "What is transcription?",
        "What is translation in biology?",
        "What is cellular respiration?",
        "What is ATP?",
        "What is homeostasis?",
        "What is the function of the nephron?",
        "What is the function of the alveoli?",
        "What is the role of chlorophyll?",
        "What is the Doppler effect?"
    };
    
    private String[] scienceAnswerBank = 
    {
        // easy — 0 to 32
        "Mercury",
        "Mars",
        "Jupiter",
        "Oxygen",
        "Carbon dioxide",
        "Water",
        "Nucleus",
        "Gravity",
        "Heart",
        "Lungs",
        "Cell",
        "Moon",
        "206",
        "100°C",
        "0°C",
        "Sun",
        "Photosynthesis",
        "Roots",
        "Skin",
        "Solar energy",
        "Herbivores",
        "Carnivores",
        "O",
        "Au",
        "8",
        "Crust",
        "Evaporation",
        "Condensation",
        "Melting",
        "Freezing",
        "Thermometer",
        "Barometer",
        "Nitrogen",

        // medium — 33 to 65
        "Na",
        "K",
        "7",
        "Electron",
        "Proton",
        "Neutron",
        "Mitochondria",
        "Nucleus",
        "Mitosis",
        "DNA",
        "Carry oxygen",
        "Fight infection",
        "Objects remain at rest or in motion unless acted upon by a net force",
        "F = ma",
        "Every action has an equal and opposite reaction",
        "Newton",
        "Joule",
        "Watt",
        "Speed in a particular direction",
        "Change in velocity over time",
        "Covalent bond",
        "Ionic bond",
        "6",
        "8",
        "CO2",
        "NaCl",
        "A community of organisms and their environment",
        "A sequence showing how energy moves between organisms",
        "Break down dead organisms and recycle nutrients",
        "The variety of life in an area",
        "Earth's axial tilt",
        "The gravitational pull of the Moon and Sun",
        "Warming caused by gases that trap heat in Earth's atmosphere",

        // hard — 66 to 99
        "Mass is the amount of matter; weight is the force of gravity on that mass",
        "Energy cannot be created or destroyed, only transferred or transformed",
        "Energy of motion",
        "Stored energy",
        "KE = 1/2 mv^2",
        "PE = mgh",
        "V = IR",
        "Ohms",
        "Series has one path; parallel has multiple paths",
        "Producing voltage from a changing magnetic field",
        "Energy cannot be created or destroyed in an isolated system",
        "A measure of disorder or energy dispersal",
        "A reaction that releases energy",
        "A reaction that absorbs energy",
        "Minimum energy required to start a reaction",
        "A substance that speeds up a reaction without being consumed",
        "Moles of solute per liter of solution",
        "6.022 × 10^23",
        "Atoms of the same element with different numbers of neutrons",
        "Time required for half of a radioactive sample to decay",
        "Survival and reproduction of organisms with advantageous inherited traits",
        "Random changes in allele frequencies",
        "Movement of alleles between populations",
        "A change in DNA",
        "Copying DNA",
        "Making RNA from DNA",
        "Using mRNA to make a protein",
        "Breaking down glucose to produce ATP",
        "The main energy-carrying molecule in cells",
        "Maintaining stable internal conditions",
        "Filters blood and forms urine",
        "Tiny air sacs where gas exchange occurs",
        "Absorbs light energy for photosynthesis",
        "Change in observed frequency due to relative motion"
    };
    
    private String[] englishQuestionBank = 
    {
        // easy — 0 to 32
        "What is a noun?",
        "What is a verb?",
        "What is an adjective?",
        "What is an adverb?",
        "What is a pronoun?",
        "What is a preposition?",
        "What is a conjunction?",
        "What is a sentence?",
        "What is a paragraph?",
        "What is a synonym?",
        "What is an antonym?",
        "What is a homonym?",
        "What is a metaphor?",
        "What is a simile?",
        "What is alliteration?",
        "What is a question?",
        "What is a statement?",
        "What punctuation ends a question?",
        "What punctuation ends most statements?",
        "What is the plural of 'child'?",
        "What is the past tense of 'go'?",
        "What is the plural of 'mouse'?",
        "What is the opposite of 'hot'?",
        "What is the opposite of 'early'?",
        "What is the synonym of 'happy'?",
        "What is the synonym of 'large'?",
        "What is the main idea?",
        "What is a title?",
        "What is a character?",
        "What is a setting?",
        "What is a plot?",
        "What is dialogue?",
        "What is a narrator?",

        // medium — 33 to 65
        "What is personification?",
        "What is hyperbole?",
        "What is irony?",
        "What is foreshadowing?",
        "What is imagery?",
        "What is symbolism?",
        "What is a theme?",
        "What is a conflict?",
        "What is a protagonist?",
        "What is an antagonist?",
        "What is first-person point of view?",
        "What is third-person point of view?",
        "What is a thesis statement?",
        "What is supporting evidence?",
        "What is a topic sentence?",
        "What is a conclusion?",
        "What is a transition?",
        "What is a dependent clause?",
        "What is an independent clause?",
        "What is a compound sentence?",
        "What is a complex sentence?",
        "What is a comma splice?",
        "What is an apostrophe used for?",
        "What is a semicolon used for?",
        "What is a colon used for?",
        "What is active voice?",
        "What is passive voice?",
        "What is an idiom?",
        "What is a rhetorical question?",
        "What is tone?",
        "What is mood?",
        "What is author's purpose?",
        "What is a counterargument?",

        // hard — 66 to 99
        "What is ethos?",
        "What is pathos?",
        "What is logos?",
        "What is exigence in rhetoric?",
        "What is a rhetorical situation?",
        "What is audience?",
        "What is genre?",
        "What is kairos?",
        "What is a claim?",
        "What is a warrant?",
        "What is a logical fallacy?",
        "What is an ad hominem fallacy?",
        "What is a straw man fallacy?",
        "What is a false dilemma?",
        "What is a slippery slope argument?",
        "What is an appeal to authority?",
        "What is circular reasoning?",
        "What is a generalization?",
        "What is diction?",
        "What is syntax?",
        "What is connotation?",
        "What is denotation?",
        "What is juxtaposition?",
        "What is paradox?",
        "What is an oxymoron?",
        "What is anaphora?",
        "What is parallelism?",
        "What is rhetorical repetition?",
        "What is a motif?",
        "What is an archetype?",
        "What is stream of consciousness?",
        "What is an unreliable narrator?",
        "What is intertextuality?",
        "What is a literary allusion?"
    };

    private String[] englishAnswerBank = 
    {
        // easy — 0 to 32
        "A person, place, thing, or idea",
        "An action or state-of-being word",
        "A word that describes a noun",
        "A word that modifies a verb, adjective, or adverb",
        "A word that replaces a noun",
        "A word showing a relationship between words",
        "A word that connects words or ideas",
        "A group of words expressing a complete thought",
        "A group of sentences about a central idea",
        "A word with a similar meaning",
        "A word with an opposite meaning",
        "A word that sounds or is spelled the same but has a different meaning",
        "A comparison without using like or as",
        "A comparison using like or as",
        "Repetition of beginning consonant sounds",
        "A sentence that asks something",
        "A sentence that gives information",
        "Question mark",
        "Period",
        "Children",
        "Went",
        "Mice",
        "Cold",
        "Late",
        "Joyful",
        "Big",
        "The central point of a text",
        "The name of a text",
        "A person or being in a story",
        "The time and place of a story",
        "The sequence of events in a story",
        "Conversation between characters",
        "The person or voice telling a story",

        // medium — 33 to 65
        "Giving human qualities to nonhuman things",
        "Extreme exaggeration",
        "A contrast between expectation and reality",
        "Hints about future events",
        "Descriptive language that appeals to the senses",
        "An object or idea representing something else",
        "The central message of a work",
        "A struggle between opposing forces",
        "The main character",
        "The character or force opposing the protagonist",
        "The narrator uses I or we",
        "The narrator refers to characters as he, she, or they",
        "The main argument of an essay",
        "Information that supports a claim",
        "The sentence stating the paragraph's main point",
        "The final section that brings ideas together",
        "A word or phrase connecting ideas",
        "A clause that cannot stand alone",
        "A clause that can stand alone",
        "A sentence with two independent clauses",
        "A sentence with an independent and dependent clause",
        "Joining two independent clauses with only a comma",
        "Showing possession or omitted letters",
        "Separating closely related independent clauses",
        "Introducing a list or explanation",
        "The subject performs the action",
        "The subject receives the action",
        "A phrase whose meaning is not literal",
        "A question asked for effect rather than an answer",
        "The author's attitude",
        "The feeling created in the reader",
        "The reason an author writes",
        "An opposing argument",

        // hard — 66 to 99
        "An appeal based on credibility or character",
        "An appeal to emotion",
        "An appeal based on logic and evidence",
        "The problem or situation that prompts a rhetorical response",
        "The context involving speaker, audience, purpose, and circumstances",
        "The intended readers or listeners",
        "A category or type of writing",
        "Using the appropriate timing or moment",
        "A statement or position being argued",
        "The reasoning connecting evidence to a claim",
        "An error in reasoning",
        "Attacking the person instead of the argument",
        "Misrepresenting an argument to make it easier to attack",
        "Presenting only two choices when more exist",
        "Claiming one event will inevitably lead to extreme consequences",
        "Using an authority as evidence without sufficient support",
        "Using the conclusion as support for itself",
        "A broad conclusion based on limited evidence",
        "Word choice",
        "The arrangement of words and phrases",
        "The associations a word carries",
        "The literal dictionary meaning",
        "Placing contrasting ideas or images together",
        "A statement that appears contradictory but may reveal truth",
        "Two contradictory terms placed together",
        "Repeating a word or phrase at the beginning of successive clauses",
        "Using similar grammatical structures",
        "Repeating words or ideas for emphasis",
        "A recurring element with symbolic significance",
        "A recurring character, image, or situation that represents a familiar pattern",
        "A technique presenting a character's continuous thoughts",
        "A narrator whose account may not be trustworthy",
        "The relationship between a text and other texts",
        "A reference to another text, person, event, or work"
    };
    
    public Order generateOrder(int questionDifficulty)
    {
        private String orderType;
        private long orderTime;
        private int fulfillOrderAmount;
        private int orderValue;

        if (Math.random() < 0.5)
        {
            orderType = "pizza";
        }
        else
        {
            orderType = "sandwich";
        }

        if (questionDifficulty == 0)
        {
            orderTime = 60;
            fulfillOrderAmount = 1;
            orderValue = 10;
        }
        else if (questionDifficulty == 1)
        {
            orderTime = 45;
            fulfillOrderAmount = 2;
            orderValue = 20;
        }
        else
        {
            orderTime = 30;
            fulfillOrderAmount = 3;
            orderValue = 30;
        }
        
        currentOrder = new Order(
            orderType,
            orderTime,
            fulfillOrderAmount,
            orderValue);

        return currentOrder;
    }
    
    public void nextQuestion(int questionDifficulty)
    {
        private int start;
        private int end;

        if (questionDifficulty == 0)
        {
            // easy questions: 0–32
            start = 0;
            end = 32;
        }
        else if (questionDifficulty == 1)
        {
            // medium questions: 33–65
            start = 33;
            end = 65;
        }
        else
        {
            // hard questions: 66–99
            start = 66;
            end = 99;
        }

        int index = start + (int)(Math.random() * (end - start + 1));

        if (subject.equalsIgnoreCase("Math"))
        {
            currentQuestion = mathQuestionBank[index];
            correctAnswer = mathAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("Science"))
        {
            currentQuestion = scienceQuestionBank[index];
            correctAnswer = scienceAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("English"))
        {
            currentQuestion = englishQuestionBank[index];
            correctAnswer = englishAnswerBank[index];
        }
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public String getCurrentQuestion()
    {
        return currentQuestion;
    }
    
    public String getCurrentAnswer()
    {
        return currentAnswer;
    }
}
