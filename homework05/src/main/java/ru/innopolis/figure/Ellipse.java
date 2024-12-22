package ru.innopolis.figure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ellipse extends Figure {

    private float radius1;
    private float radius2;

    public Ellipse(float _r1, float _r2, float _x, float _y){

        super(_x, _y);
        this.radius1 = _r1;
        this.radius2 = _r2;

    }

    public Ellipse(float _x, float _y){

        super(_x, _y);

    }

    @Override
    public float getPerimetr() {

        return (float) (2 * 3.14 * (Math.sqrt( ( (radius1*radius2) + (radius2*radius2) ) /2.0f ) ) );

    }

}
