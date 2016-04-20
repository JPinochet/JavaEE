package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class xml_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_var_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_x_parse_xml_varDom_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_x_out_select_escapeXml_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_x_forEach_select;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_x_out_select_nobody;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_import_var_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_x_parse_xml_varDom_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_x_out_select_escapeXml_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_x_forEach_select = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_x_out_select_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed_nobody.release();
    _jspx_tagPool_c_import_var_url_nobody.release();
    _jspx_tagPool_x_parse_xml_varDom_nobody.release();
    _jspx_tagPool_x_out_select_escapeXml_nobody.release();
    _jspx_tagPool_x_forEach_select.release();
    _jspx_tagPool_x_out_select_nobody.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>XML Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>XML</h1>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_fmt_formatNumber_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <br />\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_x_parse_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_x_out_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_x_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmt_formatNumber_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent(null);
    _jspx_th_fmt_formatNumber_0.setType("currency");
    _jspx_th_fmt_formatNumber_0.setValue(new String("100000.123456"));
    _jspx_th_fmt_formatNumber_0.setMaxFractionDigits(3);
    _jspx_th_fmt_formatNumber_0.setMinFractionDigits(1);
    _jspx_th_fmt_formatNumber_0.setGroupingUsed(true);
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed_nobody.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_var_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setVar("rss");
    _jspx_th_c_import_0.setUrl("http://feeds.reuters.com/reuters/topNews?format=xml");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_var_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_x_parse_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:parse
    org.apache.taglibs.standard.tag.rt.xml.ParseTag _jspx_th_x_parse_0 = (org.apache.taglibs.standard.tag.rt.xml.ParseTag) _jspx_tagPool_x_parse_xml_varDom_nobody.get(org.apache.taglibs.standard.tag.rt.xml.ParseTag.class);
    _jspx_th_x_parse_0.setPageContext(_jspx_page_context);
    _jspx_th_x_parse_0.setParent(null);
    _jspx_th_x_parse_0.setVarDom("dom");
    _jspx_th_x_parse_0.setXml((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rss}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_x_parse_0 = _jspx_th_x_parse_0.doStartTag();
    if (_jspx_th_x_parse_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_parse_xml_varDom_nobody.reuse(_jspx_th_x_parse_0);
      return true;
    }
    _jspx_tagPool_x_parse_xml_varDom_nobody.reuse(_jspx_th_x_parse_0);
    return false;
  }

  private boolean _jspx_meth_x_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:out
    org.apache.taglibs.standard.tag.rt.xml.ExprTag _jspx_th_x_out_0 = (org.apache.taglibs.standard.tag.rt.xml.ExprTag) _jspx_tagPool_x_out_select_escapeXml_nobody.get(org.apache.taglibs.standard.tag.rt.xml.ExprTag.class);
    _jspx_th_x_out_0.setPageContext(_jspx_page_context);
    _jspx_th_x_out_0.setParent(null);
    _jspx_th_x_out_0.setSelect("$dom//*[name()='channel']/*[name()='title'][1]");
    _jspx_th_x_out_0.setEscapeXml(false);
    int _jspx_eval_x_out_0 = _jspx_th_x_out_0.doStartTag();
    if (_jspx_th_x_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_out_select_escapeXml_nobody.reuse(_jspx_th_x_out_0);
      return true;
    }
    _jspx_tagPool_x_out_select_escapeXml_nobody.reuse(_jspx_th_x_out_0);
    return false;
  }

  private boolean _jspx_meth_x_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:forEach
    org.apache.taglibs.standard.tag.common.xml.ForEachTag _jspx_th_x_forEach_0 = (org.apache.taglibs.standard.tag.common.xml.ForEachTag) _jspx_tagPool_x_forEach_select.get(org.apache.taglibs.standard.tag.common.xml.ForEachTag.class);
    _jspx_th_x_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_x_forEach_0.setParent(null);
    _jspx_th_x_forEach_0.setSelect("$dom//*[name()='item']");
    int[] _jspx_push_body_count_x_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_x_forEach_0 = _jspx_th_x_forEach_0.doStartTag();
      if (_jspx_eval_x_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <a href=\"");
          if (_jspx_meth_x_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_x_forEach_0, _jspx_page_context, _jspx_push_body_count_x_forEach_0))
            return true;
          out.write("\">\n");
          out.write("                ");
          if (_jspx_meth_x_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_x_forEach_0, _jspx_page_context, _jspx_push_body_count_x_forEach_0))
            return true;
          out.write("\n");
          out.write("            </a><br />\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_x_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_x_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_x_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_x_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_x_forEach_0.doFinally();
      _jspx_tagPool_x_forEach_select.reuse(_jspx_th_x_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_x_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_x_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_x_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:out
    org.apache.taglibs.standard.tag.rt.xml.ExprTag _jspx_th_x_out_1 = (org.apache.taglibs.standard.tag.rt.xml.ExprTag) _jspx_tagPool_x_out_select_nobody.get(org.apache.taglibs.standard.tag.rt.xml.ExprTag.class);
    _jspx_th_x_out_1.setPageContext(_jspx_page_context);
    _jspx_th_x_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_x_forEach_0);
    _jspx_th_x_out_1.setSelect("./*[name()='link']");
    int _jspx_eval_x_out_1 = _jspx_th_x_out_1.doStartTag();
    if (_jspx_th_x_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_out_select_nobody.reuse(_jspx_th_x_out_1);
      return true;
    }
    _jspx_tagPool_x_out_select_nobody.reuse(_jspx_th_x_out_1);
    return false;
  }

  private boolean _jspx_meth_x_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_x_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_x_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:out
    org.apache.taglibs.standard.tag.rt.xml.ExprTag _jspx_th_x_out_2 = (org.apache.taglibs.standard.tag.rt.xml.ExprTag) _jspx_tagPool_x_out_select_escapeXml_nobody.get(org.apache.taglibs.standard.tag.rt.xml.ExprTag.class);
    _jspx_th_x_out_2.setPageContext(_jspx_page_context);
    _jspx_th_x_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_x_forEach_0);
    _jspx_th_x_out_2.setSelect("./*[name()='title']");
    _jspx_th_x_out_2.setEscapeXml(false);
    int _jspx_eval_x_out_2 = _jspx_th_x_out_2.doStartTag();
    if (_jspx_th_x_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_out_select_escapeXml_nobody.reuse(_jspx_th_x_out_2);
      return true;
    }
    _jspx_tagPool_x_out_select_escapeXml_nobody.reuse(_jspx_th_x_out_2);
    return false;
  }
}
