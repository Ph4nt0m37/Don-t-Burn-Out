package project1;

import java.util.Random;

/**
 * Handles the creation of customer orders and the selection of questions for
 * the Don't Burn Out game.
 * <p>
 * This class stores the question and answer banks for Math, Science, and
 * English. It can also use custom questions loaded through a
 * {@link CustomQuestionHandler}.
 * </p>
 * <p>
 * The {@code OrderHandler} is responsible for generating orders based on the
 * current question difficulty and selecting questions that match the difficulty
 * of the current order.
 * </p>
 * 
 * @author Brinda Amidyala
 * @author Paulo Korowajczuk Nader
 */
public class OrderHandler
{
    /**
     * The order currently being completed by the player.
     */
    private Order currentOrder;

    /**
     * The subject from which questions should be selected.
     */
    private String subject;

    /**
     * The question currently being asked.
     */
    private String currentQuestion;

    /**
     * The answer to the current question.
     */
    private String currentAnswer;

    /**
     * The bank of Math questions organized by difficulty.
     */
    private String[] mathQuestionBank = {

        // easy — 0 to 32

        "What is 5 + 7?", "What is 12 - 5?", "What is 6 * 4?",
        "What is 20 / 5?", "What is 10 + 15?", "What is 30 - 12?",
        "What is 7 * 3?", "What is 36 / 6?", "What is 9 + 8?",
        "What is 25 - 10?", "What is 5 * 5?", "What is 48 / 8?",
        "What is 14 + 9?", "What is 40 - 17?", "What is 8 * 4?",
        "What is 63 / 7?", "What is 11 + 12?", "What is 50 - 25?",
        "What is 9 * 6?", "What is 72 / 9?", "What is 15 + 16?",
        "What is 60 - 24?", "What is 7 * 8?", "What is 81 / 9?",
        "What is 18 + 17?", "What is 100 - 45?", "What is 12 * 5?",
        "What is 96 / 12?", "What is 22 + 19?", "What is 75 - 28?",
        "What is 11 * 7?", "What is 144 / 12?", "What is 25% of 100?",

        // medium — 33 to 65

        "What is 15% of 200?", "Solve: x + 7 = 15.", "Solve: x - 9 = 12.",
        "Solve: 3x = 21.", "Solve: x / 4 = 6.", "What is 3/4 + 1/4?",
        "What is 5/6 - 1/6?", "What is 2/3 * 3/4?",
        "What is 3/5 divided by 1/5?",
        "What is the perimeter of a rectangle with length 8 and width 5?",
        "What is the area of a rectangle with length 9 and width 4?",
        "What is the area of a triangle with base 10 and height 6?",
        "What is the average of 10, 20, and 30?",
        "What is the next number: 2, 4, 8, 16, ___?", "What is 2^5?",
        "What is the square root of 144?", "Simplify: 3(x + 4).",
        "Solve: 2x + 5 = 15.", "Solve: 4x - 3 = 17.",
        "What is the slope between (1,2) and (3,6)?",
        "What is the y-intercept of y = 2x + 5?", "Convert 0.75 to a fraction.",
        "Convert 3/5 to a decimal.", "What is 30% of 250?",
        "A shirt costs $40 and is 25% off. What is the sale price?",
        "What is the probability of rolling a 6 on a standard die?",
        "What is the probability of getting heads when flipping a fair coin?",
        "Simplify: 5x + 3x.", "Simplify: 7x - 2x + 4.", "Solve: 5x + 10 = 35.",
        "What is the circumference of a circle with radius 5?",
        "What is the area of a circle with radius 3?",
        "What is the volume of a rectangular prism measuring 2 × 3 × 4?",

        // hard — 66 to 99

        "Solve: 3x + 7 = 25.", "Solve: 5x - 8 = 32.", "Solve: 2(x + 3) = 18.",
        "Solve: 4(x - 2) = 28.", "Solve: 3x + 5 = 2x + 14.",
        "Solve: 7x - 4 = 3x + 20.", "Factor: x^2 + 5x + 6.", "Factor: x^2 - 9.",
        "Expand: (x + 3)(x + 4).", "Expand: (x - 2)(x + 5).",
        "Solve: x^2 = 49.", "Solve: x^2 - 9 = 0.",
        "What is the slope of a line perpendicular to y = 2x + 1?",
        "What is the distance between (0,0) and (3,4)?",
        "What is the midpoint of (2,4) and (6,8)?", "Simplify: (2x^2)(3x^3).",
        "Simplify: x^5 / x^2.", "Simplify: (x^3)^2.", "What is log10(1000)?",
        "What is 2^3 * 2^4?", "Solve: 2^x = 32.", "Solve: x/3 + 4 = 10.",
        "A right triangle has legs 6 and 8. What is its hypotenuse?",
        "What is the area of a trapezoid with bases 8 and 12 and height 5?",
        "What is the volume of a cylinder with radius 3 and height 4?",
        "What is the derivative of x^2?",
        "What is the derivative of 3x^2 + 2x?", "What is the integral of 2x?",
        "Evaluate: lim(x->2) (x + 3).",
        "Solve the system: x + y = 10 and x - y = 2.",
        "What is the discriminant of x^2 + 4x + 4?", "Solve: x^2 - 5x + 6 = 0.",
        "What is the probability of drawing an ace from a standard 52-card deck?",
        "If f(x) = 2x + 3, what is f(5)?" };

    /**
     * The bank of answers corresponding to the Math question bank.
     */
    private String[] mathAnswerBank = {

        // easy — 0 to 32

        "12", "7", "24", "4", "25", "18", "21", "6", "17", "15", "25", "6",
        "23", "23", "32", "9", "23", "25", "54", "8", "31", "36", "56", "9",
        "35", "55", "60", "8", "41", "47", "77", "12", "25",

        // medium — 33 to 65

        "30", "8", "21", "7", "24", "1", "2/3", "1/2", "3", "26", "36", "30",
        "20", "32", "32", "12", "3x + 12", "5", "5", "2", "5", "3/4", "0.6",
        "75", "$30", "1/6", "1/2", "8x", "5x + 4", "5", "10π", "9π", "24",

        // hard — 66 to 99

        "6", "8", "6", "9", "9", "6", "(x+2)(x+3)", "(x-3)(x+3)",
        "x^2 + 7x + 12", "x^2 + 3x - 10", "7 or -7", "3 or -3", "-1/2", "5",
        "(4,6)", "6x^5", "x^3", "x^6", "3", "128", "5", "18", "10", "50", "36π",
        "2x", "6x + 2", "x^2 + C", "5", "6", "0", "0", "1/13", "13" };

    /**
     * The bank of Science questions organized by difficulty.
     */
    private String[] scienceQuestionBank = {
        // easy — 0 to 32

        "What planet is closest to the Sun?",
        "What planet is known as the Red Planet?",
        "What is the largest planet in our solar system?",
        "What gas do humans need to breathe?",
        "What gas do plants absorb during photosynthesis?",
        "What is H2O commonly called?", "What is the center of an atom called?",
        "What force pulls objects toward Earth?",
        "What organ pumps blood through the body?",
        "What organ is primarily responsible for breathing?",
        "What is the basic unit of life?", "What is Earth's natural satellite?",
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
        "What gas makes up most of Earth's atmosphere?",

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
        "What do red blood cells transport?",
        "What is the main function of white blood cells?",
        "What is the SI unit of force?", "What is the SI unit of energy?",
        "What is the SI unit of power?", "What is velocity?",
        "What is acceleration?",
        "What type of bond involves sharing electrons?",
        "What type of bond involves transferring electrons?",
        "What is the atomic number of carbon?",
        "What is the atomic number of oxygen?",
        "What is the chemical formula for carbon dioxide?",
        "What is the chemical formula for table salt?", "What is an ecosystem?",
        "What is a food chain?", "What is the role of decomposers?",
        "What is biodiversity?",

        // hard — 66 to 99

        "What is the SI unit of mass?",
        "What type of energy does a moving object have?",
        "What type of energy is stored energy?",
        "What is the SI unit of electrical resistance?",
        "What law relates voltage, current, and resistance?",
        "What process generates electricity from changing magnetic fields?",
        "What quantity measures disorder in a system?",
        "What type of reaction releases energy?",
        "What type of reaction absorbs energy?",
        "What is the minimum energy needed to start a reaction called?",
        "What substance speeds up a chemical reaction without being consumed?",
        "What is the unit of molarity?", "What is Avogadro's number?",
        "What do you call atoms of the same element with different numbers of neutrons?",
        "What is the time required for half of a radioactive sample to decay called?",
        "What process describes the survival of organisms with advantageous traits?",
        "What process causes random changes in allele frequencies?",
        "What process moves alleles between populations?",
        "What is a change in DNA called?", "What process copies DNA?",
        "What process makes RNA from DNA?",
        "What process makes proteins from mRNA?",
        "What process breaks down glucose to produce ATP?",
        "What molecule is the main energy carrier in cells?",
        "What process maintains stable internal conditions?",
        "What is the functional unit of the kidney?",
        "What structures in the lungs are responsible for gas exchange?",
        "What pigment allows plants to absorb light?",
        "What effect causes a change in observed frequency due to motion?",
        "What is the SI unit of energy?", "What is the SI unit of power?",
        "What is the SI unit of force?",
        "What is the SI unit of electric charge?",
        "What is the SI unit of frequency?" };

    /**
     * The bank of answers corresponding to the Science question bank.
     */
    private String[] scienceAnswerBank = {
        // easy — 0 to 32

        "Mercury", "Mars", "Jupiter", "Oxygen", "Carbon dioxide", "Water",
        "Nucleus", "Gravity", "Heart", "Lungs", "Cell", "Moon", "206", "100",
        "0", "Sun", "Photosynthesis", "Roots", "Skin", "Solar energy",
        "Herbivores", "Carnivores", "O", "Au", "8", "Crust", "Evaporation",
        "Condensation", "Melting", "Freezing", "Thermometer", "Barometer",
        "Nitrogen",

        // medium — 33 to 65

        "Na", "K", "Seven", "Electron", "Proton", "Neutron", "Mitochondria",
        "Nucleus", "Mitosis", "DNA", "Oxygen", "Fight infection", "Newton",
        "Joule", "Watt", "Velocity", "Acceleration", "Covalent", "Ionic", "6",
        "8", "Carbon dioxide", "Sodium chloride", "Ecosystem", "Food chain",
        "Decomposers", "Biodiversity",

        // hard — 66 to 99

        "Kilogram", "Kinetic", "Potential", "Ohm", "Ohm's law", "Induction",
        "Entropy", "Exothermic", "Endothermic", "Activation", "Catalyst",
        "Molar", "6.022e23", "Isotopes", "Half-life", "Selection", "Drift",
        "Gene flow", "Mutation", "Replication", "Transcription", "Translation",
        "Respiration", "ATP", "Homeostasis", "Nephron", "Alveoli",
        "Chlorophyll", "Doppler", "Joule", "Watt", "Newton", "Coulomb",
        "Hertz" };

    /**
     * The bank of English questions organized by difficulty.
     */
    private String[] englishQuestionBank = {
        // easy — 0 to 32
        "A person, place, thing, or idea is a ______.",
        "An action or state-of-being word is a ______.",
        "A word that describes a noun is an ______.",
        "A word that modifies a verb, adjective, or adverb is an ______.",
        "A word that replaces a noun is a ______.",
        "A word that shows a relationship between words is a ______.",
        "A word that connects words or ideas is a ______.",
        "A group of words expressing a complete thought is a ______.",
        "A group of sentences about a central idea is a ______.",
        "A word with a similar meaning is a ______.",
        "A word with an opposite meaning is an ______.",
        "A word with multiple meanings that sound or are spelled the same is a ______.",
        "A comparison without using like or as is a ______.",
        "A comparison using like or as is a ______.",
        "Repetition of beginning consonant sounds is ______.",
        "A sentence that asks something is a ______.",
        "A sentence that gives information is a ______.",
        "The punctuation mark used to end a question is a ______.",
        "The punctuation mark usually used to end a statement is a ______.",
        "The plural of child is ______.", "The past tense of go is ______.",
        "The plural of mouse is ______.", "The opposite of hot is ______.",
        "The opposite of early is ______.", "A synonym for happy is ______.",
        "A synonym for large is ______.",
        "The central point of a text is its ______.",
        "The name of a text is its ______.",
        "A person or being in a story is a ______.",
        "The time and place of a story is its ______.",
        "The sequence of events in a story is its ______.",
        "Conversation between characters is called ______.",
        "The person or voice telling a story is the ______.",
        // medium — 33 to 65
        "Giving human qualities to nonhuman things is ______.",
        "Extreme exaggeration is called ______.",
        "A contrast between expectation and reality is ______.",
        "Hints about future events are called ______.",
        "Descriptive language that appeals to the senses is called ______.",
        "An object or idea representing something else is a ______.",
        "The central message of a work is its ______.",
        "A struggle between opposing forces is a ______.",
        "The main character of a story is the ______.",
        "The character or force opposing the protagonist is the ______.",
        "A point of view using I or we is ______ person.",
        "A point of view using he, she, or they is ______ person.",
        "The main argument of an essay is the ______.",
        "Information that supports a claim is called ______.",
        "The sentence stating a paragraph's main point is the ______ sentence.",
        "The final section of an essay is the ______.",
        "A word or phrase connecting ideas is a ______.",
        "A clause that cannot stand alone is ______.",
        "A clause that can stand alone is ______.",
        "A sentence with two independent clauses is ______.",
        "A sentence with an independent and dependent clause is ______.",
        "Joining two independent clauses with only a comma is a comma ______.",
        "Showing possession or omitted letters uses an ______.",
        "A punctuation mark separating closely related independent clauses is a ______.",
        "A punctuation mark introducing a list or explanation is a ______.",
        "When the subject performs the action, the voice is ______.",
        "When the subject receives the action, the voice is ______.",
        "A phrase whose meaning is not literal is an ______.",
        "A question asked for effect rather than an answer is ______.",
        "The author's attitude is called ______.",
        "The feeling created in the reader is called ______.",
        "The reason an author writes is the author's ______.",
        "An opposing argument is a ______.",
        // hard — 66 to 99
        "An appeal based on credibility or character is ______.",
        "An appeal to emotion is ______.",
        "An appeal based on logic and evidence is ______.",
        "The problem that prompts a rhetorical response is the ______.",
        "The context involving speaker, audience, purpose, and circumstances is the rhetorical ______.",
        "The intended readers or listeners are the ______.",
        "A category or type of writing is a ______.",
        "Using the appropriate timing or moment is called ______.",
        "A statement or position being argued is a ______.",
        "The reasoning connecting evidence to a claim is the ______.",
        "An error in reasoning is a ______.",
        "Attacking the person instead of the argument is ______.",
        "Misrepresenting an argument to make it easier to attack is a ______.",
        "Presenting only two choices when more exist is a ______.",
        "Claiming one event will inevitably lead to extreme consequences is a ______.",
        "Using an authority as evidence without sufficient support is an ______.",
        "Using the conclusion as support for itself is ______.",
        "A broad conclusion based on limited evidence is a ______.",
        "An author's word choice is called ______.",
        "The arrangement of words and phrases is ______.",
        "The associations a word carries are its ______.",
        "The literal dictionary meaning of a word is its ______.",
        "Placing contrasting ideas or images together is ______.",
        "A statement that appears contradictory but may reveal truth is a ______.",
        "Two contradictory terms placed together form an ______.",
        "Repeating a word or phrase at the beginning of successive clauses is ______.",
        "Using similar grammatical structures is ______.",
        "Repeating words or ideas for emphasis is ______.",
        "A recurring element with symbolic significance is a ______.",
        "A recurring character, image, or situation representing a familiar pattern is an ______.",
        "A technique presenting a character's continuous thoughts is ______.",
        "A narrator whose account may not be trustworthy is ______.",
        "The relationship between a text and other texts is ______.",
        "A reference to another text, person, event, or work is an ______." };

    /**
     * The bank of answers corresponding to the English question bank.
     */
    private String[] englishAnswerBank = {
        // easy — 0 to 32
        "Noun", "Verb", "Adjective", "Adverb", "Pronoun", "Preposition",
        "Conjunction", "Sentence", "Paragraph", "Synonym", "Antonym", "Homonym",
        "Metaphor", "Simile", "Alliteration", "Question", "Statement",
        "Questionmark", "Period", "Children", "Went", "Mice", "Cold", "Late",
        "Joyful", "Big", "Mainidea", "Title", "Character", "Setting", "Plot",
        "Dialogue", "Narrator",
        // medium — 33 to 65
        "Personification", "Hyperbole", "Irony", "Foreshadowing", "Imagery",
        "Symbol", "Theme", "Conflict", "Protagonist", "Antagonist", "First",
        "Third", "Thesis", "Evidence", "Topic", "Conclusion", "Transition",
        "Dependent", "Independent", "Compound", "Complex", "Splice",
        "Apostrophe", "Semicolon", "Colon", "Active", "Passive", "Idiom",
        "Rhetorical", "Tone", "Mood", "Purpose", "Counterargument",
        // hard — 66 to 99
        "Ethos", "Pathos", "Logos", "Exigence", "Situation", "Audience",
        "Genre", "Kairos", "Claim", "Warrant", "Fallacy", "Adhominem",
        "Strawman", "Dilemma", "Slippery", "Authority", "Circular",
        "Generalization", "Diction", "Syntax", "Connotation", "Denotation",
        "Juxtaposition", "Paradox", "Oxymoron", "Anaphora", "Parallelism",
        "Repetition", "Motif", "Archetype", "Consciousness", "Unreliable",
        "Intertextuality", "Allusion" };

    /**
     * Handles questions loaded from a custom questions file.
     */
    private CustomQuestionHandler customQuestionHandler;

    /**
     * Handles the player's equipment and shop-related information.
     */
    private ShopHandler shopHandler;

    /**
     * Creates an OrderHandler for the standard built-in question banks.
     *
     * @param shopHandler
     *            the ShopHandler used to access the player's equipment and its
     *            effects on orders
     */
    public OrderHandler(ShopHandler shopHandler)
    {
        this.shopHandler = shopHandler;
    }


    /**
     * Creates an OrderHandler that uses custom questions.
     *
     * @param questionHandler
     *            the handler used to retrieve custom questions
     * @param shopHandler
     *            the ShopHandler used to access the player's equipment and its
     *            effects on orders
     */
    public OrderHandler(
        CustomQuestionHandler questionHandler,
        ShopHandler shopHandler)
    {
        this.customQuestionHandler = questionHandler;
        this.shopHandler = shopHandler;
    }


    /**
     * Generates a new customer order based on the specified question
     * difficulty.
     * <p>
     * The order type is randomly selected from the available food items. The
     * time allowed, number of questions required, and monetary value depend on
     * the specified difficulty. The player's equipment time multiplier is also
     * applied to the time allowed.
     * </p>
     * <p>
     * Difficulty 0 generates an order requiring one question and worth $10.
     * Difficulty 1 generates an order requiring two questions and worth $20.
     * Difficulty 2 or higher generates an order requiring three questions and
     * worth $30.
     * </p>
     *
     * @param questionDifficulty
     *            the difficulty level of the order
     * @return the newly generated customer order
     */
    public Order generateOrder(int questionDifficulty)
    {
        String orderType;
        long orderTime = 0;
        int fulfillOrderAmount = 0;
        int orderValue = 0;

        double rand = Math.random();

        if (rand < 0.1)
        {
            orderType = "pizza";
        }
        else if (rand < 0.2)
        {
            orderType = "sandwich";
        }
        else if (rand < 0.3)
        {
            orderType = "pasta";
        }
        else if (rand < 0.4)
        {
            orderType = "chicken";
        }
        else if (rand < 0.5)
        {
            orderType = "steak";
        }
        else if (rand < 0.6)
        {
            orderType = "burger";
        }
        else if (rand < 0.7)
        {
            orderType = "hot dog";
        }
        else if (rand < 0.8)
        {
            orderType = "taco";
        }
        else if (rand < 0.9)
        {
            orderType = "burrito";
        }
        else
        {
            orderType = "fries";
        }

        if (questionDifficulty == 0)
        {
            orderTime =
                (long)(60 * shopHandler.getUserEquipment().getTimeMult());
            fulfillOrderAmount = 1;
            orderValue = 10;
        }
        else if (questionDifficulty == 1)
        {
            orderTime =
                (long)(50 * shopHandler.getUserEquipment().getTimeMult());
            fulfillOrderAmount = 2;
            orderValue = 20;
        }
        else
        {
            orderTime =
                (long)(40 * shopHandler.getUserEquipment().getTimeMult());
            fulfillOrderAmount = 3;
            orderValue = 30;
        }

        currentOrder = new Order(
            orderType,
            orderTime,
            fulfillOrderAmount,
            orderValue,
            questionDifficulty);

        return currentOrder;
    }


    /**
     * Selects the next question based on the current subject and the difficulty
     * of the current order.
     * <p>
     * For Math, Science, and English, a random question is selected from the
     * appropriate section of the corresponding question bank. When the subject
     * is Custom, the {@link CustomQuestionHandler} is used to retrieve a
     * question and answer.
     * </p>
     */
    public void nextQuestion()
    {
        if (subject.equalsIgnoreCase("Math"))
        {
            Random random = new Random();

            int index = random.nextInt(mathQuestionBank.length / 3)
                + (mathQuestionBank.length / 3
                    * currentOrder.getQuestionDifficulty());

            currentQuestion = mathQuestionBank[index];
            currentAnswer = mathAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("Science"))
        {
            Random random = new Random();

            int index = random.nextInt(scienceQuestionBank.length / 3)
                + (scienceQuestionBank.length / 3
                    * currentOrder.getQuestionDifficulty());

            currentQuestion = scienceQuestionBank[index];
            currentAnswer = scienceAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("English"))
        {
            Random random = new Random();

            int index = random.nextInt(englishQuestionBank.length / 3)
                + (englishQuestionBank.length / 3
                    * currentOrder.getQuestionDifficulty());

            currentQuestion = englishQuestionBank[index];
            currentAnswer = englishAnswerBank[index];
        }
        else if (subject.equalsIgnoreCase("Custom"))
        {
            String[] qAndA = customQuestionHandler
                .getQuestionAndAnswer(currentOrder.getQuestionDifficulty());

            currentQuestion = qAndA[0];
            currentAnswer = qAndA[1];
        }
    }


    /**
     * Sets the subject used to determine which question bank should provide
     * questions.
     *
     * @param subject
     *            the subject to use, such as Math, Science, English, or Custom
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }


    /**
     * Gets the question currently being asked.
     *
     * @return the current question
     */
    public String getCurrentQuestion()
    {
        return currentQuestion;
    }


    /**
     * Gets the correct answer to the current question.
     *
     * @return the current question's correct answer
     */
    public String getCurrentQuestionAnswer()
    {
        return currentAnswer;
    }
}
