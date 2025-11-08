# Deploy2025
- Manasa: 
    Home Screen:
        TEXT BOX: weight (user can enter their weight)
        STARTING PLANETS BELOW: Moon, Mara, Saturn (maybe more later but lets just start w/ these for now)
            - These planets are clickable and will display planet image and data based off users weight
        BUTTON: View Solar System - takes user to see all planets they have made
        BUTTON: Make planet Button:
            Takes you to another page that allows you to choose what to add to your planet
                1: color of planet
                2: Trees
                3: Mountains
                4: Clounds
                5: Water
                maybe more later but start w these 
                Button that says "Make planet" -> this button will Call Mai's function that creates a planet objects out of these attributes
                -After Make planet button is pushed user should be taken to a new page that displayes the planet(Made by Ram)
                    -Button on this page that says "Add to Solar System" -> if this button is pushed Mais code will add it to a linked list "Solar System" 
- Ram:
    - Creating images for planets Moon, Mara, Saturn (maybe more later but lets just start w/ these for now)
    - Creating basic planets and different attributes for user made planets(ie. trees, mountains etc)
    - Reads visual Planet Object attributes and combining different them into one visual representation for user made planets
        -Manasa will retrieve and display on users screen
    - Physics class that has methods to calculate different physics attributes like gravity on other planets, also mass etc.
        |_> Mais class will call on rams methods to create planet objects

-Mai:
    - Make planet class:
        -reads planet data given from "Make planet" page and creates planet objects to be shown on front end screen.
        -send relevent weight data to Ram for gravity calculation
        Methods:
            -Create planet()
            -Delete planet()
            -AddToSolarSystem()
        Calls On:
            Rams physicsCalculater class to get gravity, user weight, etc -> add to planet data for object
        Sends to:
            - sends finished planet to Manasa to display on front end
            -also sends updated version of the list (Solar System) 

