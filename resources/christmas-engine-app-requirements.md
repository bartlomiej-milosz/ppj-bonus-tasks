## Class ChristmasEngine

### Fields:

	-Fields are to be selected by student

### Functions:

	-showName() - prints out name of the factory
	-countGifts() - returns int amount of all created gifts using this Class
	-createGift(String giftContent,weight) - adds gift to array of gifts in ChristmassEngine
	-createGift() - adds gift to array of gifts in ChristmasEngine. Name of the gift is randomly choosen from: [Car,Doll,Ball] and random weight between 1 and 10.
	-createGift(String giftContent) - adds gift (with default wieight =5) to array of gifts in ChristmasEngine
	-createGifts(String[] names, int[] weights) - adds multiple gifts to array of gifts in ChristmasEngine
	-countAverageWeight() - returns average weight of gifts.

## Class Santa

### Fields:

	-Fields are to be selected by student
### Functions:

	-getChristmasEngine() - returns assigned ChristmasEngine object.
	-dropGift() - returns oldest gift from the array of gifts and removes it.
	-fly() - prints "Let's go!" if Santa's array of reindeers is full and all reindeers are healthy, else prints "I'm afraid I can't do that"
	-giveGift(Child c) - removes oldest gift from the array and passes it to the Child. Automatically Child opens the present and print "Oh, thank you for: /gift name/". If child is naughty, gift is not passed on and proper information is printed.

## Class Child

### Fields:

	-Fields are to be selected by student
	
### Functions:

	-openGift() - prints out the name of the received gift, deletes it and
	-changeAttitude() - changes child from nice to naughty or from naughty to nice.
