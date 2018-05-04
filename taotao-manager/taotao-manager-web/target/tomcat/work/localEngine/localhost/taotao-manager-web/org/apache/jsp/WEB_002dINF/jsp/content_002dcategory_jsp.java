package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class content_002dcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t <ul id=\"contentCategory\" class=\"easyui-tree\">\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"contentCategoryMenu\" class=\"easyui-menu\" style=\"width:120px;\" data-options=\"onClick:menuHandler\">\r\n");
      out.write("    <div data-options=\"iconCls:'icon-add',name:'add'\">添加</div>\r\n");
      out.write("    <div data-options=\"iconCls:'icon-remove',name:'rename'\">重命名</div>\r\n");
      out.write("    <div class=\"menu-sep\"></div>\r\n");
      out.write("    <div data-options=\"iconCls:'icon-remove',name:'delete'\">删除</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#contentCategory\").tree({\r\n");
      out.write("\t\turl : '/content/category/list',\r\n");
      out.write("\t\tanimate: true,\r\n");
      out.write("\t\tmethod : \"GET\",\r\n");
      out.write("\t\tonContextMenu: function(e,node){\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("            $(this).tree('select',node.target);\r\n");
      out.write("            $('#contentCategoryMenu').menu('show',{\r\n");
      out.write("                left: e.pageX,\r\n");
      out.write("                top: e.pageY\r\n");
      out.write("            });\r\n");
      out.write("        },\r\n");
      out.write("        onAfterEdit : function(node){\r\n");
      out.write("        \tvar _tree = $(this);\r\n");
      out.write("        \tif(node.id == 0){\r\n");
      out.write("        \t\t// 新增节点\r\n");
      out.write("        \t\t$.post(\"/content/category/create\",{parentId:node.parentId,name:node.text},function(data){\r\n");
      out.write("        \t\t\tif(data.status == 200){\r\n");
      out.write("        \t\t\t\t_tree.tree(\"update\",{\r\n");
      out.write("            \t\t\t\ttarget : node.target,\r\n");
      out.write("            \t\t\t\tid : data.data.id\r\n");
      out.write("            \t\t\t});\r\n");
      out.write("        \t\t\t}else{\r\n");
      out.write("        \t\t\t\t$.messager.alert('提示','创建'+node.text+' 分类失败!');\r\n");
      out.write("        \t\t\t}\r\n");
      out.write("        \t\t});\r\n");
      out.write("        \t}else{\r\n");
      out.write("        \t\t$.post(\"/content/category/update\",{id:node.id,name:node.text});\r\n");
      out.write("        \t}\r\n");
      out.write("        }\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function menuHandler(item){\r\n");
      out.write("\tvar tree = $(\"#contentCategory\");\r\n");
      out.write("\tvar node = tree.tree(\"getSelected\");\r\n");
      out.write("\tif(item.name === \"add\"){\r\n");
      out.write("\t\ttree.tree('append', {\r\n");
      out.write("            parent: (node?node.target:null),\r\n");
      out.write("            data: [{\r\n");
      out.write("                text: '新建分类',\r\n");
      out.write("                id : 0,\r\n");
      out.write("                parentId : node.id\r\n");
      out.write("            }]\r\n");
      out.write("        }); \r\n");
      out.write("\t\tvar _node = tree.tree('find',0);\r\n");
      out.write("\t\ttree.tree(\"select\",_node.target).tree('beginEdit',_node.target);\r\n");
      out.write("\t}else if(item.name === \"rename\"){\r\n");
      out.write("\t\ttree.tree('beginEdit',node.target);\r\n");
      out.write("\t}else if(item.name === \"delete\"){\r\n");
      out.write("\t\t$.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){\r\n");
      out.write("\t\t\tif(r){\r\n");
      out.write("\t\t\t\t$.post(\"/content/category/delete/\",{parentId:node.parentId,id:node.id},function(){\r\n");
      out.write("\t\t\t\t\ttree.tree(\"remove\",node.target);\r\n");
      out.write("\t\t\t\t});\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
