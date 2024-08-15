package chess.exceptions;

import boardgame.exceptions.TabuleiroException;

import java.io.Serial;

public class XadrezException extends TabuleiroException {
    @Serial
    private static final long serialVersionUID = 1L;

    public XadrezException(String mensagem) {
        super(mensagem);
    }
}
