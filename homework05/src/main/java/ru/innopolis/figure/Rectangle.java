package ru.innopolis.figure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Rectangle extends Figure {

    private float length;
    private float width;

    public Rectangle(float _length, float _width, float _x, float _y) {

        super(_x, _y);
        this.length = _length;
        this.width = _width;

    }

    public Rectangle(float _x, float _y){

        super(_x, _y);
    }

    @Override
    public float getPerimetr() {

        return (float) (2 * (length + width));

    }
}