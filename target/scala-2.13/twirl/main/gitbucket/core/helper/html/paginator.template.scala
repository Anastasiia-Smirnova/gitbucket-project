
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
/*1.2*/import gitbucket.core.view.helpers

object paginator extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Int,Int,Int,Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(page: Int, count: Int, limit: Int, width: Int, baseURL: String = ""):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/defining(gitbucket.core.view.Pagination(page, count, limit, width))/*3.69*/{ p =>_display_(Seq[Any](format.raw/*3.75*/("""
  """),_display_(if(p.count > p.limit)/*4.25*/{_display_(Seq[Any](format.raw/*4.26*/("""
    """),format.raw/*5.5*/("""<div>
      <ul class="pagination">
        """),_display_(if(page == 1)/*7.23*/{_display_(Seq[Any](format.raw/*7.24*/("""
          """),format.raw/*8.11*/("""<li class="disabled"><span>&#9664;</span></li>
        """)))}else/*9.16*/{_display_(Seq[Any](format.raw/*9.17*/("""
          """),format.raw/*10.11*/("""<li><a href=""""),_display_(/*10.25*/helpers/*10.32*/.appendQueryString(baseURL, s"page=${page - 1 }")),format.raw/*10.81*/("""">&#9664;</a></li>
        """)))}),format.raw/*11.10*/("""
        """),_display_(/*12.10*/for(i <- 1 to p.max) yield /*12.30*/{_display_(Seq[Any](format.raw/*12.31*/("""
          """),_display_(if(i == p.max && p.omitRight)/*13.41*/{_display_(Seq[Any](format.raw/*13.42*/("""
            """),format.raw/*14.13*/("""<li><span>&hellip;</span></li>
          """)))} else {null} ),format.raw/*15.12*/("""
          """),_display_(if(i == page)/*16.25*/{_display_(Seq[Any](format.raw/*16.26*/("""
            """),format.raw/*17.13*/("""<li class="active"><span>"""),_display_(/*17.39*/i),format.raw/*17.40*/("""</span></li>
          """)))}else/*18.18*/{_display_(Seq[Any](format.raw/*18.19*/("""
            """),_display_(if(p.visibleFor(i))/*19.33*/{_display_(Seq[Any](format.raw/*19.34*/("""
              """),format.raw/*20.15*/("""<li><a href=""""),_display_(/*20.29*/helpers/*20.36*/.appendQueryString(baseURL, s"page=$i")),format.raw/*20.75*/("""">"""),_display_(/*20.78*/i),format.raw/*20.79*/("""</a></li>
            """)))} else {null} ),format.raw/*21.14*/("""
          """)))}),format.raw/*22.12*/("""
          """),_display_(if(i == 1 && p.omitLeft)/*23.36*/{_display_(Seq[Any](format.raw/*23.37*/("""
            """),format.raw/*24.13*/("""<li><span>&hellip;</span></li>
          """)))} else {null} ),format.raw/*25.12*/("""
        """)))}),format.raw/*26.10*/("""
        """),_display_(if(page == p.max)/*27.27*/{_display_(Seq[Any](format.raw/*27.28*/("""
          """),format.raw/*28.11*/("""<li class="disabled"><span>&#9654;</span></li>
        """)))}else/*29.16*/{_display_(Seq[Any](format.raw/*29.17*/("""
          """),format.raw/*30.11*/("""<li><a href=""""),_display_(/*30.25*/helpers/*30.32*/.appendQueryString(baseURL, s"page=${page + 1}")),format.raw/*30.80*/("""">&#9654;</a></li>
        """)))}),format.raw/*31.10*/("""
      """),format.raw/*32.7*/("""</ul>
    </div>
  """)))} else {null} ),format.raw/*34.4*/("""
""")))}),format.raw/*35.2*/("""
"""))
      }
    }
  }

  def render(page:Int,count:Int,limit:Int,width:Int,baseURL:String): play.twirl.api.HtmlFormat.Appendable = apply(page,count,limit,width,baseURL)

  def f:((Int,Int,Int,Int,String) => play.twirl.api.HtmlFormat.Appendable) = (page,count,limit,width,baseURL) => apply(page,count,limit,width,baseURL)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/paginator.scala.html
                  HASH: 271379e589c7e9ea470a092e65be9970b74efe0d
                  MATRIX: 285->1|644->37|807->108|882->175|925->181|976->206|1014->207|1045->212|1129->270|1167->271|1205->282|1283->344|1321->345|1360->356|1401->370|1417->377|1487->426|1546->454|1583->464|1619->484|1658->485|1726->526|1765->527|1806->540|1892->582|1944->607|1983->608|2024->621|2077->647|2099->648|2146->678|2185->679|2245->712|2284->713|2327->728|2368->742|2384->749|2444->788|2474->791|2496->792|2563->815|2606->827|2669->863|2708->864|2749->877|2835->919|2876->929|2930->956|2969->957|3008->968|3087->1030|3126->1031|3165->1042|3206->1056|3222->1063|3291->1111|3350->1139|3384->1146|3447->1166|3479->1168
                  LINES: 10->1|15->2|20->3|20->3|20->3|21->4|21->4|22->5|24->7|24->7|25->8|26->9|26->9|27->10|27->10|27->10|27->10|28->11|29->12|29->12|29->12|30->13|30->13|31->14|32->15|33->16|33->16|34->17|34->17|34->17|35->18|35->18|36->19|36->19|37->20|37->20|37->20|37->20|37->20|37->20|38->21|39->22|40->23|40->23|41->24|42->25|43->26|44->27|44->27|45->28|46->29|46->29|47->30|47->30|47->30|47->30|48->31|49->32|51->34|52->35
                  -- GENERATED --
              */
          