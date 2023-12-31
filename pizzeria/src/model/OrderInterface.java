

package model;

import view.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderInterface {


    ArrayList<Item> getMenuList()throws RemoteException;

    Object[] getPizzaType();

    void setPizzaType(Object obj, int index);

    void buttonPressed(ButtonType button) throws Exception;

    Object[] getSize();

    void setPizzaSize(Object obj, int index);

    void pizzaListIndexChanged(int index);

}
