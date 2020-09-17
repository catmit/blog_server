package com.catmit.blog.server.web.entity.vo;

public class Page <T>{
    private int offset;
    private int limit;
    private int count;

    private boolean hasNext;
    private boolean hasPreview;

    private T data;

    private Page(PageBuilder<T> PageBuilder) {
        this.offset = PageBuilder.offset;
        this.limit = PageBuilder.limit;
        this.count = PageBuilder.count;
        this.hasNext = PageBuilder.hasNext;
        this.hasPreview = PageBuilder.hasPreview;
        this.data = PageBuilder.data;
    }

    public static class PageBuilder<T>{
        private int offset;
        private int limit;
        private int count;

        private boolean hasNext;
        private boolean hasPreview;

        private T data;

        public PageBuilder<T> offset(int offset){
            this.offset = offset;
            return this;
        }
        public PageBuilder<T> limit(int limit){
            this.limit = limit;
            return this;
        }
        public PageBuilder<T> count(int count){
            this.count = count;
            return this;
        }
        public PageBuilder<T> data(T data){
            this.data = data;
            return this;
        }
        public Page<T> build(){
            this.hasNext = (offset + limit) < count;
            this.hasPreview = !(offset == 0 || offset/limit == 0 || offset == limit);
            return new Page<>(this);
        }
    }

    @Override
    public String toString() {
        return String.format("offset: %d \t limit: %d \t count: %d \t hasNext: %s \t hasPrevious: %s \n",
                offset, limit, count, hasNext, hasPreview);
    }

}
