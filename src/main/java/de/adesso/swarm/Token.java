package de.adesso.swarm;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Token {
    @Id
    private Long id;
    private TokenClass tokenClass;
    private String tokenValue;
    public static Long currentMaxId = 3L;

    private static final Map<TokenClass, Long> idMap = new HashMap<>();

    static {
        idMap.put(TokenClass.SESSION_TOKEN, 1L);
        idMap.put(TokenClass.REFRESH_TOKEN, 2L);
        idMap.put(TokenClass.ACCESS_TOKEN, 3L);
    }

    public Token() {
        // The new id needs to be larger than the most recent one but at least higher than the highest fixed id
        this("N/A", TokenClass.UNDEFINED);
    }

    public Token(String _tValue, TokenClass _tClass) {
        tokenClass = _tClass;
        tokenValue = _tValue;
        if (tokenClass == TokenClass.UNDEFINED) {
            id = ++currentMaxId;
        } else
            id = idMap.get(tokenClass);
    }

    public Long getId() {
        return id;
    }

    public TokenClass getTokenClass() {
        return tokenClass;
    }

    // TODO secure that change of class = change of id
    //  think about other entries possibly changing
    public void setTokenClass(TokenClass tokenClass) {
        this.tokenClass = tokenClass;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    // TODO maybe sanitize input
    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public static Long getCurrentMaxId() {
        return currentMaxId;
    }

    public static Map<TokenClass, Long> getIdMap() {
        return idMap;
    }
}
