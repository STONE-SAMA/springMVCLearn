接受请求的参数，使用处理器方法的形参
    1)HttpServletRequest
    2)HttpServletResponse
    3)HttpSession
    4)用户提交的数据

接受用户提交的参数
    逐个接收
    对象接收

注意
    get请求方式提交参数时，中文没有乱码
    使用post方式提交请求时，中文有乱码，需要使用过滤器处理乱码问题
        过滤器可以自定义，也可使用框架提供的