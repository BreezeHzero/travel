package com.hy.travel.mapper;

import com.hy.travel.dao.FavoriteDao;
import com.hy.travel.model.Favorite;
import com.hy.travel.model.MyFavorite;
import com.hy.travel.model.Route;
import org.junit.Test;

import java.util.List;

/**
 * Title:com.hy.travel.mapper
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/21 9:24
 */
public class FavoriteTest {
    FavoriteDao dao = new FavoriteDao();
    @Test
    public void test(){
        boolean b = dao.cancelFavorite(15, 1);
        System.out.println(b);
    }

    @Test
    public void test2(){
        /*List<MyFavorite> myFavorite = dao.findMyFavorite(15);
        for (int i = 0; i < myFavorite.size(); i++) {
            MyFavorite favorite = myFavorite.get(i);
            System.out.println(favorite.getDate());
        }*/
        /*List<MyFavorite> list = dao.findFavoriteNum("西安", 0, 10);
        for (int i = 0; i < list.size(); i++) {
            MyFavorite favorite = list.get(i);
            System.out.println(favorite.getNum());//3
            System.out.println(favorite.getRname());//
        }*/
    }

    @Test
    public void test3(){
        List<MyFavorite> list = dao.randFind();
        for (int i = 0; i < list.size(); i++) {
            MyFavorite favorite = list.get(i);
            System.out.println(favorite.getRname());
        }
    }
}
