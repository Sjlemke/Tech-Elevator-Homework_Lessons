package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
        int raccoons = 3;
        int goHome = 2;
        int raccoonsLeft = raccoons - goHome;
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
        int flowers = 5;
        int bees = 3;
        int lessBees = flowers - bees;
        
        System.out.println(flowers - bees);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
        int lonelyPigeon = 1;
        int anotherPigeon = 1;
        int totalPigeons = lonelyPigeon + anotherPigeon;
        
        System.out.println(lonelyPigeon + anotherPigeon);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
        int owlsOnFence = 3;
        int moreOwls = 2;
        int totalOwls = owlsOnFence + moreOwls;
        
        System.out.println(owlsOnFence + moreOwls);
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
        int workingBeavers = 2;
        int swimmingBeaver = 1;
        int remainingBeaversHome = workingBeavers - swimmingBeaver;
        
        System.out.println(workingBeavers - swimmingBeaver);
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
        int toucansTreeLimb = 2;
        int toucanJoining = 1;
        int totalToucans = toucansTreeLimb + toucanJoining;
        
        System.out.println(toucansTreeLimb + toucanJoining);
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
        int squirrels = 4;
        int nuts = 2;
        int moreSquirrelsThanNuts = squirrels - nuts;
        
        System.out.println(squirrels - nuts);
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
        int quarter = 25;
        int dime = 10;
        int nickelOne = 5;
        int nickelTwo = 5;
        int totalSum = quarter + dime + nickelOne + nickelTwo;
        
        System.out.println(quarter + dime + nickelOne + nickelTwo);
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
        int briersClass = 18;
        int macadamsClass = 20;
        int flannerysClass = 17;
        int totalFirstGrade = briersClass + macadamsClass + flannerysClass;
        
        System.out.println(briersClass + macadamsClass + flannerysClass);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
        int yoyo = 24;
        int whistle = 14;
        int totalSpent = yoyo + whistle;
        
        System.out.println(yoyo + whistle);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
        int largeMarshmallows = 8;
        int miniMarshmallows = 10;
        int totalMarshmallows = largeMarshmallows + miniMarshmallows;
        
        System.out.println(largeMarshmallows + miniMarshmallows);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
        int hiltsSnow = 29;
        int brecknockSnow = 17;
        int moreSnow = hiltsSnow - brecknockSnow;
        
        System.out.println(hiltsSnow - brecknockSnow);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
        double hiltHas = 10.00;
        double toyTruck = 3.00;
        double pencil = 2.00;
        double moneyLeft = hiltHas - toyTruck - pencil;
        System.out.println(hiltHas - toyTruck - pencil);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
        int marbles = 16;
        int lostMarbles = 7;
        int marblesRemaining = marbles - lostMarbles;
        System.out.println(marbles - lostMarbles);
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
        int seashellsOwned = 19;
        int totalSeashellsDesired = 25;
        int seashellsLeftToFind = totalSeashellsDesired - seashellsOwned;
        System.out.println(totalSeashellsDesired - seashellsOwned);
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
        int totalBalloons = 17;
        int redBalloons = 8;
        int greenBalloons = totalBalloons - redBalloons;
        System.out.println(totalBalloons - redBalloons);
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
         int booksOnShelf = 38;
         int addedBooks = 10;
         int totalBooksOnShelf = booksOnShelf + addedBooks;
         System.out.println(booksOnShelf + addedBooks);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
         int beeLegs = 6;
         int eightBees = 8;
         int totalBeeLegs = beeLegs * eightBees;
         System.out.println(beeLegs * eightBees);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
        int boughtCones = 2;
        double price = .99;
        double costOfTwoCones = boughtCones * price;
        System.out.println(costOfTwoCones * boughtCones);
        
   
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
        int totalNeededRocks = 125;
        int rocksOwned = 64;
        int rocksToBuy = totalNeededRocks - rocksOwned;
        System.out.println(totalNeededRocks - rocksOwned);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
        int hiltMarbles = 38;
        int marblesLost = 15;
        int marblesLeft = hiltMarbles - marblesLost;
        System.out.println(hiltMarbles - marblesLost);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
        int milesToConcert = 78;
        int milesBeforeGas = 32;
        int milesRemaining = milesToConcert - milesBeforeGas;
        System.out.println(milesToConcert - milesBeforeGas);
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
        int satMorning = 90;
        int satAfternoon = 45;
        int totalMinutes = satMorning + satAfternoon;
        System.out.println(satMorning + satAfternoon);
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
        int hotdogsBought = 6;
        double pricePerHotDog = 0.50;
        double totalCost = hotdogsBought * pricePerHotDog;
        System.out.println(hotdogsBought * pricePerHotDog);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
        int hiltMoney = 50;
        int pencilCost = 7;
        int canBuy = hiltMoney / pencilCost;
        System.out.println(hiltMoney / pencilCost);
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
        int butterfliesSeen = 33;
        int orangeButterflies = 20;
        int redButterflies = butterfliesSeen - orangeButterflies;
        System.out.println(butterfliesSeen - redButterflies);
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
        double kateGave = 1.00;
        double kateCandy = 0.54;
        double changeBack = kateGave - kateCandy;
        System.out.println(kateGave - kateCandy);
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
         int marksTrees = 13;
         int addedTrees = 12;
         int totalTrees = marksTrees + addedTrees;
         
         System.out.println(marksTrees + addedTrees);
         
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
         int hours = 24;
         int days = 2;
         int totalHours = hours * days;
         System.out.println(hours * days);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
        int cousins = 4;
        int piecesOfGum = 5;
        int gumNeeded = cousins * piecesOfGum;
        System.out.println(cousins * piecesOfGum);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
        double danHad = 3.00;
        double candyBar = 1.00;
        double danMoneyLeft = danHad - candyBar;
        System.out.println(danHad - candyBar);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
        int boats = 5;
        int peoplePerBoat = 3;
        int totalPeopleOnBoats = boats * peoplePerBoat;
        System.out.println(boats * peoplePerBoat);
        
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
        int legosHad = 380;
        int legosLost = 57;
        int legosLeft = legosHad - legosLost;
        System.out.println(legosHad - legosLost);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
        int totalMuffinsNeeded = 83;
        int muffinsBaked = 35;
        int muffinsLeftToBake = totalMuffinsNeeded - muffinsBaked;
        
        System.out.println(totalMuffinsNeeded - muffinsBaked);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
        int crayonsWilly = 1400;
        int crayonsLucy = 290;
        int crayonsDifference = crayonsWilly - crayonsLucy;
        System.out.println(crayonsWilly - crayonsLucy);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
        int stickersPerPage = 10;
        int numberOfPages = 22;
        int totalStickers = stickersPerPage * numberOfPages;
        System.out.println(stickersPerPage * numberOfPages);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
        int totalCupcakes = 96;
        int numberOfChildren = 8;
        int cupcakesEach = totalCupcakes / numberOfChildren;
        System.out.println(totalCupcakes / numberOfChildren);
      
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
        int gingerbreadCookies = 47;
        int perJar = 6;
        int notInJar = gingerbreadCookies % perJar;
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
        int croissants = 59;
        int neighbors = 8;
        int marian = croissants % neighbors;
        System.out.println(croissants % neighbors);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
        int cookiesOnTray = 12;
        int cookiesNeeded = 276;
        int traysNeeded = cookiesNeeded / cookiesOnTray;
        System.out.println(cookiesNeeded / cookiesOnTray );
        /*
        43. Marian???s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
        int totalPretzels = 480;
        int oneServing = 12;
        int servingsNeeded = totalPretzels / oneServing;
        System.out.println(totalPretzels / oneServing);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
        int lemonCupcakes = 50;
        int cupcakesPerBox = 3;
        int boxesGivenAway = lemonCupcakes / cupcakesPerBox;
        System.out.println(lemonCupcakes / cupcakesPerBox);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
        int carrotSticks = 74;
        int people = 12;
        int leftUneaten = carrotSticks % people;
        System.out.println(carrotSticks % people);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
        int totalTeddyBears = 98;
        int teddysPerShelf = 7;
        int filledShelves = totalTeddyBears / teddysPerShelf;
        System.out.println(totalTeddyBears / teddysPerShelf);
       
        /*
        47. Susie???s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
        int totalPictures = 480;
        int albumHolds = 20;
        int albumsNeeded = totalPictures / albumHolds; 
        System.out.println(totalPictures / albumHolds);
        /*
        48. Joe, Susie???s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
        int scatteredTradingCards = 94;
        int boxCanHold = 8;
        int boxesfilled = scatteredTradingCards / boxCanHold;
        System.out.println(scatteredTradingCards / boxCanHold);
        /*
        49. Susie???s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
         int totalBooks = 210;
         int repairedShelves = 10;
         int booksPerShelf = totalBooks / repairedShelves; 
         System.out.println(totalBooks / repairedShelves);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
        int croissantsBaked = 17;
        int guests = 7;
        int eachWillHave = croissantsBaked / guests; 
        System.out.println(croissantsBaked / guests);
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
