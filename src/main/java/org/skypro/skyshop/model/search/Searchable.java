package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getTypeContent();

    String getSearchTerm();

    UUID getId();

    default String getStringRepresentation() {
        return getSearchTerm();
    }

    default SearchResult toSearchResult(){
        return SearchResult.fromSearchable(this);
    };
}
