package ru.innopolis.figure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
abstract public class Figure {

    float x = 0.0f;
    float y = 0.0f;

    Figure(float _x, float _y){

        this.x = _x;
        this.y = _y;

    }

    public float getPerimetr(){

        return 0.0f;

    }

}
