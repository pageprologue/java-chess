package chess.domain.movement;

import chess.domain.board.Board;
import chess.domain.piece.Piece;
import chess.domain.position.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueenMoveStrategy extends MoveStrategy {
    private static final List<Direction> QUEEN_DIRECTIONS = Direction.QUEEN_DIRECTIONS;

    @Override
    public boolean canMove(Board board, Piece source, Piece target) {
        validate(source, target);
        Set<Position> movablePositions = getMovablePositions(board, source);
        return checkMovablePosition(movablePositions, target.getPosition());
    }

    @Override
    public Set<Position> getMovablePositions(Board board, Piece source) {
        Set<Position> movablePositions = new HashSet<>();
        for (Direction direction : QUEEN_DIRECTIONS) {
            movablePositions.addAll(repeatMovablePositions(board, direction, source.getPosition()));
            movablePositions.addAll(attackMovablePosition(board, direction, source.getPosition()));
        }
        return movablePositions;
    }
}