package usine.modele.usine;

import usine.modele.piece.Piece;
import usine.modele.machines.Machine;

/**
 * Poste de l'usine qui contient une machine.
 * @author PIVARD Julien, CLECH Sandy
 */
public class PlaceMachine
{

    /**
     * La machine que l'on va utiliser.
     * */
    protected Machine machine;

    /**
     * Stock une machine.
     * @param machine
     * La machine à mettre à cet emplacement.
     * */
    public PlaceMachine(Machine machine)
    {
        this.machine = machine;
    }

    /**
     * @param machine
     * La machine à mettre à cet emplacement.
     * */
    public void setMachine(Machine machine)
    {
        this.machine = machine;
    }

    /**
     * @return La machine assigné à l'emplacement.
     * */
    public Machine getMachine()
    {
        return machine;
    }

    /**
     * @param piece
     * La pièce à usiner par la machine.
     * @return L'usinage à modifié la pièce.
     * */
    public boolean usiner(Piece piece)
    {
        return machine.usiner(piece);
    }

    
    /**
     * change la machine courante en la machine suivante
     */
    public void machineSuivante(){
    	this.machine = this.machine.machineSuivante();
    }
}
