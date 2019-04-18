import Main from '@/components/main'

/**
 * iview-admin中meta除了原生参数外可配置的参数:
 * meta: {
 *  title: { String|Number|Function }
 *         显示在侧边栏、面包屑和标签栏的文字
 *         使用'{{ 多语言字段 }}'形式结合多语言使用，例子看多语言的路由配置;
 *         可以传入一个回调函数，参数是当前路由对象，例子看动态路由和带参路由
 *  hideInBread: (false) 设为true后此级路由将不会出现在面包屑中，示例看QQ群路由配置
 *  hideInMenu: (false) 设为true后在左侧菜单不会显示该页面选项
 *  notCache: (false) 设为true后页面在切换标签后不会缓存，如果需要缓存，无需设置这个字段，而且需要设置页面组件name属性和路由配置的name一致
 *  access: (null) 可访问该页面的权限数组，当前路由设置的权限会影响子路由
 *  icon: (-) 该页面在左侧菜单、面包屑和标签导航处显示的图标，如果是自定义图标，需要在图标名称前加下划线'_'
 *  beforeCloseName: (-) 设置该字段，则在关闭当前tab页时会去'@/router/before-close.js'里寻找该字段名对应的方法，作为关闭前的钩子函数
 * }
 */

export default [
  {
    path: '/login',
    name: 'login',
    meta: {
      title: 'zywok-app - 登录',
      hideInMenu: true
    },
    component: () => import('@/view/login/login.vue')
  },
  {
    path: '/',
    name: '_home',
    redirect: '/home',
    component: Main,
    meta: {
      hideInMenu: true,
      notCache: true
    },
    children: [
      {
        path: '/home',
        name: 'home',
        meta: {
          hideInMenu: true,
          title: '首页',
          notCache: true,
          icon: 'md-home'
        },
        component: () => import('@/view/single-page/home')
      }
    ]
  },
  // {
  //   path: '',
  //   name: 'doc',
  //   meta: {
  //     title: '文档',
  //     href: 'https://lison16.github.io/iview-admin-doc/#/',
  //     icon: 'ios-book'
  //   }
  // },
  {
    path: '/admin',
    name: 'user_manage',
    meta: {
      icon: 'md-person',
      title: '用户管理'
    },
    component: Main,
    children: [
      {
        path: 'User',
        name: 'user_list',
        meta: {
          title: '用户列表',
          icon: 'ios-person'
        },
        component: () => import('@/view/user/User.vue')
      },
      {
        path: 'ShippingAddress',
        name: 'receiving_address_manage',
        meta: {
          title: '收货地址管理',
          icon: 'ios-home'
        },
        component: () => import('@/view/shipping-address/ShippingAddress.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'user_fund_manage',
    meta: {
      icon: 'logo-usd',
      title: '用户资金管理'
    },
    component: Main,
    children: [
      {
        path: 'UserWallet',
        name: 'wallet_manage',
        meta: {
          title: '钱包管理',
          icon: 'md-cash'
        },
        component: () => import('@/view/user-wallet/UserWallet.vue')
      },
      {
        path: 'UserBankcard',
        name: 'bank_card_manage',
        meta: {
          title: '银行卡管理',
          icon: 'ios-card'
        },
        component: () => import('@/view/user-bankcard/UserBankcard.vue')
      },
      {
        path: 'AccountDetail',
        name: 'user_account_manage',
        meta: {
          title: '用户账目管理',
          icon: 'ios-clipboard-outline'
        },
        component: () => import('@/view/account-detail/AccountDetail.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'system_manage',
    meta: {
      icon: 'ios-cog',
      title: '系统管理'
    },
    component: Main,
    children: [
      {
        path: 'Role',
        name: 'role_manage',
        meta: {
          title: '角色管理',
          icon: 'md-medal'
        },
        component: () => import('@/view/role/Role.vue')
      },
      {
        path: 'Module',
        name: 'module_manage',
        meta: {
          title: '模块管理',
          icon: 'ios-color-filter'
        },
        component: () => import('@/view/module/Module.vue')
      },
      {
        path: 'Permission',
        name: 'permission_manage',
        meta: {
          title: '权限管理',
          icon: 'ios-color-filter-outline'
        },
        component: () => import('@/view/permission/Permission.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'system_config_manage',
    meta: {
      icon: 'md-cog',
      title: '系统配置管理'
    },
    component: Main,
    children: [
      {
        path: 'SysConfig',
        name: 'system_config',
        meta: {
          title: '系统配置',
          icon: 'ios-cog-outline'
        },
        component: () => import('@/view/sys-config/SysConfig.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'system_monitoring',
    meta: {
      icon: 'md-eye',
      title: '缓存管理'
    },
    component: Main,
    children: [
      {
        path: 'RedisCache',
        name: 'redis_cache',
        meta: {
          title: 'Redis缓存',
          icon: 'ios-ionitron-outline'
        },
        component: () => import('@/view/redis-cache/RedisCache.vue')
      }, 
      {
        path: 'SysLog',
        name: 'system_log',
        meta: {
          title: '系统日志',
          icon: 'ios-paper'
        },
        component: () => import('@/view/sys-log/SysLog.vue')
      },
      {
        path: 'Scheduler',
        name: 'timing_task',
        meta: {
          title: '定时任务',
          icon: 'md-time'
        },
        component: () => import('@/view/scheduler/Scheduler.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'notice_manage',
    meta: {
      icon: 'md-notifications',
      title: '公告管理'
    },
    component: Main,
    children: [
      {
        path: 'Notice',
        name: 'system_notice',
        meta: {
          title: '系统公告',
          icon: 'ios-notifications'
        },
        component: () => import('@/view/notice/Notice.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'hide_menu',
    meta: {
      icon: 'md-person',
      title: '隐藏菜单'
    },
    component: Main,
    children: [
      {
        path: 'Info',
        name: 'info',
        meta: {
          title: '个人信息',
          icon: 'ios-contact',
          hideInMenu: true,
          notCache: true
        },
        component: () => import('@/view/info/Info.vue')
      }
    ]
  },
  // {
  //   path: '/user',
  //   name: '单独页面',
  //   meta: {
  //     hideInMenu: true
  //   },
  //   component: Main,
  //   children: [
  //     {
  //       path: 'role-permission-page',
  //       name: '角色权限分配',
  //       meta: {
  //         title: '角色权限分配',
  //         notCache: true,
  //         icon: 'ios-build'
  //       },
  //       component: () => import('@/view/role-permission/RolePermission.vue')
  //     }
  //   ]
  // },
  {
    path: '/401',
    name: 'error_401',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/401.vue')
  },
  {
    path: '/500',
    name: 'error_500',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/500.vue')
  },
  {
    path: '*',
    name: 'error_404',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/404.vue')
  }
]
