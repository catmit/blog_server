package com.catmit.blog.server.web.entity.vo;

public class Page <T>{
    private int offset;
    private int limit;
    private int count;

    private boolean hasNext;
    private boolean hasPreview;

    private T data;

    private Page(Builder<T> builder) {
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.count = builder.count;
        this.hasNext = builder.hasNext;
        this.hasPreview = builder.hasPreview;
        this.data = builder.data;
    }

    public static class Builder<T>{
        private int offset;
        private int limit;
        private int count;

        private boolean hasNext;
        private boolean hasPreview;

        private T data;

        public Builder<T> offset(int offset){
            this.offset = offset;
            return this;
        }
        public Builder<T> limit(int limit){
            this.limit = limit;
            return this;
        }
        public Builder<T> count(int count){
            this.count = count;
            return this;
        }
        public Builder<T> data(T data){
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
