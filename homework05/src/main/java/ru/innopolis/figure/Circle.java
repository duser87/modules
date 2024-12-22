package ru.innopolis.figure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.innopolis.App;

@Getter
@Setter
@ToString
public class Circle extends Ellipse implements Movelable {

    private float radius;

    public Circle(float r, float _x, float _y){

        super(_x, _y);
        this.radius = r;
    }

    @Override
    public float getPerimetr() {

        return (float) (2 * 3.14 * radius);

    }

    @Override
    public void move(float _x, float _y) {

        this.x = _x;
        this.y = _y;

    }

}
