package com.woshuwu.model;

/**
 * 分类，分类包括多级分类，也就是有子分类。一级分类（跟目录）8位，二级分类16位，最多四级，也就是32位，更好是int。
 * 一级目录的第一个0x0000 0001 0000 0000 0000 0000 0000 0000，二级目录第一个0x0000 0001 0000 0001 0000 0000 0000 0000
 * Author: ljj
 * Date: 12-9-12
 * Time: 下午11:38
 */
public class Category {

    private long id;

    /**
     * varchar max(20)
     */
    private String name;

    private Category[] parentCategories;

    public long[] getParentCategoryIds(){
        long id1 = this.id & 0xff000000;
        long id2 = this.id & 0xffff0000;
        long id3 = this.id & 0xffffff00;
        if((this.id & 0x00ffffff) == 0){
             return new long[]{};//root category
        }else if((this.id & 0x0000ffff) == 0){
             return new long[]{id1};
        }else if((this.id & 0x000000ff) == 0){
            return new long[]{id1,id2};
        }else{
            return new long[]{id1,id2,id3};
        }
    }

    //======== setter and getter method
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category[] getParentCategories() {
        return parentCategories;
    }

    public void setParentCategories(Category[] parentCategories) {
        this.parentCategories = parentCategories;
    }

}
