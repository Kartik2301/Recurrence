package LLDQuestions.Chess.Inventory;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.Chess.Piece.Piece;

public class Inventory {
    private Piece king;
    private Piece queen;
    private List<Piece> knights;
    private List<Piece> bishops;
    private List<Piece> rocks;
    private List<Piece> pawns;

    public Inventory() {
        knights = new ArrayList<>();
        bishops = new ArrayList<>();
        rocks = new ArrayList<>();
        pawns = new ArrayList<>();
    }

    public void setKing(Piece king) {
        this.king = king;
    }

    public void setQueen(Piece queen) {
        this.queen = queen;
    }

    public void setKnights(List<Piece> knights) {
        this.knights = knights;
    }

    public void setBishops(List<Piece> bishops) {
        this.bishops = bishops;
    }

    public void setRocks(List<Piece> rocks) {
        this.rocks = rocks;
    }

    public void setPawns(List<Piece> pawns) {
        this.pawns = pawns;
    }

    public Piece getKing() {
        return king;
    }

    public Piece getQueen() {
        return queen;
    }

    public List<Piece> getKnights() {
        return knights;
    }

    public List<Piece> getBishops() {
        return bishops;
    }

    public List<Piece> getRocks() {
        return rocks;
    }

    public List<Piece> getPawns() {
        return pawns;
    }
}
