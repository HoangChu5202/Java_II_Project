package generics;

import java.util.ArrayList;
import java.util.EmptyStackException;

public interface PushPop<T>{
    T pop();
    T push(T item);

}
