# User input for the names
username1 = input("Please enter your name: ")
username2 = input("Please enter your name: ")


while True:
    # User input for the rock, paper or scissors
    userinput1 = input("Please enter rock, paper or scissors: ")
    userinput2 = input("Please enter rock, paper or scissors: ")

    # Check the user input for the rock, paper or scissors and find the result
    if userinput1 == userinput2:
        print("Its a tie!")
        raise SystemExit
    elif userinput1 == "rock":
        if userinput2 == "scissors":
            print(username1 + " wins!")
        else:
            print(username2 + " wins!")
    elif userinput1 == "scissors":
        if userinput2 == "paper":
            print(username1 + " wins!")
        else:
            print(username2 + " wins!")
    elif userinput1 == "paper":
        if userinput2 == "rock":
            print(username1 + " wins!")
        else:
            print(username2 + " wins!")
    else:
        print("Invalid input! Please try again")

    # Repeating the game based on user decision
    repeat = input("Do you want to play again ? yes/no: ").lower()
    if repeat == "yes":
        print("Continuing.....")
    elif repeat == "no":
        raise SystemExit
    else:
        print("Invalid response!")
        raise SystemExit
