package cn.itfxq.admin.controller;


import cn.itfxq.admin.service.INewsService;
import cn.itfxq.auth.config.util.LgUtils;
import cn.itfxq.common.domain.News;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.NewsQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "新闻管理接口")
public class NewsController {
    @Autowired
    private INewsService newsService;


    @GetMapping("/news/listpage")
    @ApiOperation("查询新闻分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "NewsQuery", value = "新闻查询对象", defaultValue = "newsQuery对象")
    })
    @ResponseBody
    public ResResult listpage( NewsQuery newsQuery){
        PageList listpage = newsService.listpage(newsQuery);
        return new ResResult(ResResult.CodeStatus.OK, "获取新闻信息", listpage);
    }


    @PostMapping(value = "/news/saveNews")
    @ResponseBody
    public ResResult saveNews(@RequestBody News news, HttpServletRequest request) throws Exception {
        try {
            Long loginUserId = LgUtils.getLoginUserId(request);
            news.setUserid(loginUserId);
            newsService.saveNews(news);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "保存失败");
        }
    }

    @PutMapping(value = "/news/updateNews")
    @ResponseBody
    public ResResult updateNews(@RequestBody News news, HttpServletRequest request) throws Exception {
        try {
            Long loginUserId = LgUtils.getLoginUserId(request);
            news.setUserid(loginUserId);
            newsService.updateNews(news);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "修改失败");
        }
    }

    @DeleteMapping(value = "/news/deleteNews/{id}")
    @ResponseBody
    public ResResult deleteNews(@PathVariable("id") Long id) throws Exception {
        try {
            newsService.deleteNewsById(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "删除失败");
        }
    }

    //news/getAllNewsList
    @PostMapping(value = "/news/getAllNewsList")
    @ResponseBody
    public List<News> getAllNewsList() throws Exception {
            List<News> news = newsService.queryAll();
            return  news;
    }


    @RequestMapping(value = "/news/getNewsDetail/{id}")
    @ResponseBody
    public News getNewsDetail(@PathVariable("id") Long id) throws Exception {
           return  newsService.getNewsDetail(id);
    }






}
