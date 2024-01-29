
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object preview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template17[gitbucket.core.service.RepositoryService.RepositoryInfo,String,Boolean,Boolean,Boolean,Boolean,Boolean,String,String,String,String,String,Boolean,Boolean,Int,Long,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  content: String,
  enableWikiLink: Boolean,
  enableRefsLink: Boolean,
  enableLineBreaks: Boolean,
  enableTaskList: Boolean,
  hasWritePermission: Boolean,
  completionContext: String,
  style: String = "",
  styleClass: String = "",
  placeholder: String = "Leave a comment",
  ariaLabel: String = "Comment body",
  elastic: Boolean = false,
  focus: Boolean = false,
  tabIndex: Int = -2,
  uid: Long = new java.util.Date().getTime())(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*17.2*/import gitbucket.core.view.helpers

def /*26.8*/textarea/*26.16*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*26.20*/("""
        """),format.raw/*27.9*/("""<textarea id="content"""),_display_(/*27.31*/uid),format.raw/*27.34*/("""" class="form-control" name="content" placeholder=""""),_display_(/*27.86*/placeholder),format.raw/*27.97*/("""" style="resize: vertical; """),_display_(/*27.125*/style),format.raw/*27.130*/("""" aria-label=""""),_display_(/*27.145*/ariaLabel),format.raw/*27.154*/(""""
          """),_display_(if(tabIndex > -2)/*28.29*/{_display_(Seq[Any](format.raw/*28.30*/(""" """),format.raw/*28.31*/("""tabindex=""""),_display_(/*28.42*/tabIndex),format.raw/*28.50*/(""""""")))} else {null} ),format.raw/*28.52*/("""
          """),_display_(if(styleClass.nonEmpty)/*29.35*/{_display_(Seq[Any](format.raw/*29.36*/(""" """),format.raw/*29.37*/("""class=""""),_display_(/*29.45*/styleClass),format.raw/*29.55*/("""" """)))} else {null} ),format.raw/*29.58*/(""">"""),_display_(/*29.60*/content),format.raw/*29.67*/("""</textarea>
      """)))};
Seq[Any](format.raw/*18.1*/("""<div class="tabbable">
  <ul class="nav nav-tabs fill-width" style="margin-bottom: 10px;">
    <li class="active"><a href="#tab"""),_display_(/*20.38*/uid),format.raw/*20.41*/("""" data-toggle="tab" id="write"""),_display_(/*20.71*/uid),format.raw/*20.74*/("""">Write</a></li>
    <li><a href="#tab"""),_display_(/*21.23*/(uid + 1)),format.raw/*21.32*/("""" data-toggle="tab" id="preview"""),_display_(/*21.64*/uid),format.raw/*21.67*/("""">Preview</a></li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane active" style="margin-top: 4px;" id="tab"""),_display_(/*24.67*/uid),format.raw/*24.70*/("""">
      <span id="error-content" class="error"></span>
      """),format.raw/*30.8*/("""
      """),_display_(/*31.8*/gitbucket/*31.17*/.core.helper.html.attached(
        repository        = repository,
        completionContext = completionContext,
        generateScript    = !enableWikiLink
      )/*35.8*/(textarea)),format.raw/*35.18*/("""
    """),format.raw/*36.5*/("""</div>
    <div class="tab-pane" id="tab"""),_display_(/*37.35*/(uid + 1)),format.raw/*37.44*/("""">
      <div class="markdown-body" id="preview-area"""),_display_(/*38.51*/uid),format.raw/*38.54*/("""">
      </div>
    </div>
  </div>
</div>
<script>
$(function()"""),format.raw/*44.13*/("""{"""),format.raw/*44.14*/("""
  """),_display_(if(elastic)/*45.15*/{_display_(Seq[Any](format.raw/*45.16*/("""
    """),format.raw/*46.5*/("""$('#content"""),_display_(/*46.17*/uid),format.raw/*46.20*/("""').elastic();
    $('#content"""),_display_(/*47.17*/uid),format.raw/*47.20*/("""').trigger('blur');
  """)))} else {null} ),format.raw/*48.4*/("""
  """),_display_(if(focus)/*49.13*/{_display_(Seq[Any](format.raw/*49.14*/("""
    """),format.raw/*50.5*/("""$('#content"""),_display_(/*50.17*/uid),format.raw/*50.20*/("""').trigger('focus');
  """)))} else {null} ),format.raw/*51.4*/("""

  """),format.raw/*53.3*/("""$('#write"""),_display_(/*53.13*/uid),format.raw/*53.16*/("""').on('shown.bs.tab', function()"""),format.raw/*53.48*/("""{"""),format.raw/*53.49*/("""
    """),format.raw/*54.5*/("""$('#content"""),_display_(/*54.17*/uid),format.raw/*54.20*/("""').trigger('focus');
  """),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");

  $('#preview"""),_display_(/*57.15*/uid),format.raw/*57.18*/("""').click(function()"""),format.raw/*57.37*/("""{"""),format.raw/*57.38*/("""
    """),format.raw/*58.5*/("""$('#preview-area"""),_display_(/*58.22*/uid),format.raw/*58.25*/("""').html('<img src=""""),_display_(/*58.45*/helpers/*58.52*/.assets("/common/images/indicator.gif")),format.raw/*58.91*/(""""> Previewing...');
    $.post('"""),_display_(/*59.14*/helpers/*59.21*/.url(repository)),format.raw/*59.37*/("""/_preview', """),format.raw/*59.49*/("""{"""),format.raw/*59.50*/("""
      """),format.raw/*60.7*/("""content          : $('#content"""),_display_(/*60.38*/uid),format.raw/*60.41*/("""').val(),
      enableWikiLink   : """),_display_(/*61.27*/enableWikiLink),format.raw/*61.41*/(""",
      enableRefsLink   : """),_display_(/*62.27*/enableRefsLink),format.raw/*62.41*/(""",
      enableLineBreaks : """),_display_(/*63.27*/enableLineBreaks),format.raw/*63.43*/(""",
      enableTaskList   : """),_display_(/*64.27*/enableTaskList),format.raw/*64.41*/("""
    """),format.raw/*65.5*/("""}"""),format.raw/*65.6*/(""", function(data)"""),format.raw/*65.22*/("""{"""),format.raw/*65.23*/("""
      """),format.raw/*66.7*/("""$('#preview-area"""),_display_(/*66.24*/uid),format.raw/*66.27*/("""').html(data);
      $('#preview-area"""),_display_(/*67.24*/uid),format.raw/*67.27*/(""" """),format.raw/*67.28*/("""input').prop('disabled', true);
      prettyPrint();
    """),format.raw/*69.5*/("""}"""),format.raw/*69.6*/(""");
  """),format.raw/*70.3*/("""}"""),format.raw/*70.4*/(""");
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,content:String,enableWikiLink:Boolean,enableRefsLink:Boolean,enableLineBreaks:Boolean,enableTaskList:Boolean,hasWritePermission:Boolean,completionContext:String,style:String,styleClass:String,placeholder:String,ariaLabel:String,elastic:Boolean,focus:Boolean,tabIndex:Int,uid:Long,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,content,enableWikiLink,enableRefsLink,enableLineBreaks,enableTaskList,hasWritePermission,completionContext,style,styleClass,placeholder,ariaLabel,elastic,focus,tabIndex,uid)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,String,Boolean,Boolean,Boolean,Boolean,Boolean,String,String,String,String,String,Boolean,Boolean,Int,Long) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,content,enableWikiLink,enableRefsLink,enableLineBreaks,enableTaskList,hasWritePermission,completionContext,style,styleClass,placeholder,ariaLabel,elastic,focus,tabIndex,uid) => (context) => apply(repository,content,enableWikiLink,enableRefsLink,enableLineBreaks,enableTaskList,hasWritePermission,completionContext,style,styleClass,placeholder,ariaLabel,elastic,focus,tabIndex,uid)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/preview.scala.html
                  HASH: ee8f834a66019359ceb8982c63a2f8000e313308
                  MATRIX: 775->1|1412->566|1460->1035|1477->1043|1558->1047|1594->1056|1643->1078|1667->1081|1746->1133|1778->1144|1834->1172|1861->1177|1904->1192|1935->1201|1992->1231|2031->1232|2060->1233|2098->1244|2127->1252|2173->1254|2235->1289|2274->1290|2303->1291|2338->1299|2369->1309|2416->1312|2445->1314|2473->1321|2531->601|2686->729|2710->732|2767->762|2791->765|2857->804|2887->813|2946->845|2970->848|3118->969|3142->972|3231->1340|3265->1348|3283->1357|3457->1523|3488->1533|3520->1538|3588->1579|3618->1588|3698->1641|3722->1644|3814->1708|3843->1709|3885->1724|3924->1725|3956->1730|3995->1742|4019->1745|4076->1775|4100->1778|4166->1801|4206->1814|4245->1815|4277->1820|4316->1832|4340->1835|4407->1859|4438->1863|4475->1873|4499->1876|4559->1908|4588->1909|4620->1914|4659->1926|4683->1929|4733->1952|4761->1953|4806->1971|4830->1974|4877->1993|4906->1994|4938->1999|4982->2016|5006->2019|5053->2039|5069->2046|5129->2085|5189->2118|5205->2125|5242->2141|5282->2153|5311->2154|5345->2161|5403->2192|5427->2195|5490->2231|5525->2245|5580->2273|5615->2287|5670->2315|5707->2331|5762->2359|5797->2373|5829->2378|5857->2379|5901->2395|5930->2396|5964->2403|6008->2420|6032->2423|6097->2461|6121->2464|6150->2465|6234->2522|6262->2523|6294->2528|6322->2529|6352->2532|6380->2533
                  LINES: 14->1|32->17|34->26|34->26|36->26|37->27|37->27|37->27|37->27|37->27|37->27|37->27|37->27|37->27|38->28|38->28|38->28|38->28|38->28|38->28|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|41->18|43->20|43->20|43->20|43->20|44->21|44->21|44->21|44->21|47->24|47->24|49->30|50->31|50->31|54->35|54->35|55->36|56->37|56->37|57->38|57->38|63->44|63->44|64->45|64->45|65->46|65->46|65->46|66->47|66->47|67->48|68->49|68->49|69->50|69->50|69->50|70->51|72->53|72->53|72->53|72->53|72->53|73->54|73->54|73->54|74->55|74->55|76->57|76->57|76->57|76->57|77->58|77->58|77->58|77->58|77->58|77->58|78->59|78->59|78->59|78->59|78->59|79->60|79->60|79->60|80->61|80->61|81->62|81->62|82->63|82->63|83->64|83->64|84->65|84->65|84->65|84->65|85->66|85->66|85->66|86->67|86->67|86->67|88->69|88->69|89->70|89->70|90->71|90->71
                  -- GENERATED --
              */
          