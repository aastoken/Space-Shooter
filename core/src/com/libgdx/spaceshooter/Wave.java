package com.libgdx.spaceshooter;

public class Wave {

    int numberOfEnemies;
    float timeToNextWave;
    enum TypeOfShip {simple, advanced}
    TypeOfShip typeOfShip;

    public Wave(int number, float time, TypeOfShip type )
    {
        numberOfEnemies = number;
        timeToNextWave = time;
        typeOfShip = type;
    }

    public void SpawnWave()
    {
        //somehow the time at which each wave spawns must be available
        for (int i = 0; i < numberOfEnemies; i++)
        {
            switch (typeOfShip)
            {
                case simple:
                    WorldController.instance.getCurrentLevel().Instantiate(new SimpleEnemy(0,0));
                    break;
                case advanced:
                    WorldController.instance.getCurrentLevel().Instantiate(new AdvancedEnemy(-WorldController.instance.getCurrentLevel().background.width/2 + (float)Math.random() * WorldController.instance.getCurrentLevel().background.width,80, AdvancedEnemy.WaypointType.curveL));
                    break;
            }
        }

    }



}
