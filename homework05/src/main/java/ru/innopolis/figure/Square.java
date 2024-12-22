package ru.innopolis.figure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Square extends Rectangle implements Movelable {

    private float length;

    public Square(float _length, float _x, float _y) {

        super( _x, _y);
        this.length = _length;

    }

    @Override
    public float getPerimetr() {

        return (float) (4 * length);

    }

    @Override
    public void move(float _x, float _y) {

        this.x = _x;
        this.y = _y;

    }
}