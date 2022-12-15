package com.projetonttdata.CRUDAlunos.resources;

import com.sun.istack.NotNull;

public class Pages {

    @NotNull
    private String name;
    private Integer page = 1;
    private Integer size = 10;

    public Pages() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
